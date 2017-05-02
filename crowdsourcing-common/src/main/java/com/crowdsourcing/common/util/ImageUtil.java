package com.crowdsourcing.common.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/***
* 图像处理工具类 
* @author  HiYellowC
* @date 创建时间：2017年3月16日 下午3:11:40 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class ImageUtil {

	private static int size = 32;
	
	private static int smallerSize = 8;
	
	public static String getHash(InputStream is) throws Exception {
		BufferedImage img = ImageIO.read(is);
		
		/*
		 * 1.Reduce size
		 */
		img = resize(img, size, size);
		
		/*
		 * 2. reduce color
		 */
		img = grayscale(img);
		
		double[][] vals = new double[size][size];
		
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				vals[x][y] = getBlue(img, x, y);
//				System.out.println("x: " + x + "y: " + y + "vals: " + vals[x][y]);
			}
		}
		
		/*
		 * 3. compute the DCT
		 */
		long start = System.currentTimeMillis();
		double[][] dctVals = applyDCT(vals);
		System.out.println("DCT: " + (System.currentTimeMillis() - start));
//		double[][] dctVals = vals;
		/*
		 * 4. reduce the DCT
		 * 5. compute the average value
		 */
		double total = 0;
		
		for (int x = 0; x < smallerSize; x++) {
			for (int y = 0; y < smallerSize; y++) {
				total += dctVals[x][y];
			}
		}
		total -= dctVals[0][0];
		
		double avg = total / (double) ((smallerSize * smallerSize) - 1);
		
		/*
		 * 6. further reduce the DCT
		 */
		String hash = "";
		
		for (int x = 0; x < smallerSize; x++) {
			for (int y = 0; y < smallerSize; y++) {
				if (x != 0 && y != 0) {
					hash += (dctVals[x][y] > avg ? "1" : "0");
				}
			}
		}
		System.out.println("hash: " + hash);
		return hash;
	}
	
	private static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		
		return resizedImage;
	}
	
	private static ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
	
	private static BufferedImage grayscale(BufferedImage img) {
		colorConvert.filter(img, img);
		return img;
	}
	
	private static int getBlue(BufferedImage img, int x, int y) {
		return (img.getRGB(x, y)) & 0xff;
	}
	
	private static double[] c;
	static {
		c = new double[size];
		
		for (int i = 1; i < size; i++) {
			c[i] = 1;
		}
		c[0] = 1 / Math.sqrt(2.0);
	}
	
	/*
	 * ???
	 */
	private static double[][] applyDCT(double[][] f) {
		int N = size;
		
		double[][] F = new double[N][N];
		for (int u = 0; u < N; u++) {
			for (int v = 0; v < N; v++) {
				double sum = 0.0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						sum += Math.cos(((2 * i + 1) / (2.0 * N)) * u * Math.PI) 
								* Math.cos(((2 * j + 1) / (2.0 * N)) * v * Math.PI)
								* (f[i][j]);
					}
				}
				sum *= ((c[u] * c[v]) / 4.0);
				F[u][v] = sum;
			}
		}
		return F;
	}
	
	public static int distance(String s1, String s2) {
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		int total = 0;
		for (int k = 0; k < s1.length(); k++) {
			if (s1.charAt(k) != s2.charAt(k)) {
				total++;
			}
		}
		return total;
	}
	
	public static byte[] imageDrawLine(byte[] bytes, double x, double y, double width, double height, Color color) throws IOException {
		BufferedImage image = bytesToImage(bytes);
		Graphics2D graphics2d = image.createGraphics();
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(3.0f));
		graphics2d.drawRect(new Double(x + 0.5).intValue(), new Double(y + 0.5).intValue(), new Double(width + 0.5).intValue(), new Double(height + 0.5).intValue());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", byteArrayOutputStream);
		byte[] result = byteArrayOutputStream.toByteArray();
		return result;
	}
	
	private static BufferedImage bytesToImage(byte[] bytes) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
		BufferedImage image = ImageIO.read(inputStream);
		return image;
	}
	
}
