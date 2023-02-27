package com.teibok.models;

public class CommonData {
	private static String compressedFilePath;
	private static String uncompressedFilePath;
	private static String downloadCompressedFilePath;
	private static String downloadDecompressedFilePath;
	private static String downloadCompressedFileName;
	private static String downloadDecompressedFileName;
	
	public static String getCompressedFilePath() {
		return compressedFilePath;
	}
	public static void setCompressedFilePath(String compressedFilePath) {
		CommonData.compressedFilePath = compressedFilePath;
	}
	public static String getUncompressedFilePath() {
		return uncompressedFilePath;
	}
	public static void setUncompressedFilePath(String uncompressedFilePath) {
		CommonData.uncompressedFilePath = uncompressedFilePath;
	}
	public static String getDownloadCompressedFilePath() {
		return downloadCompressedFilePath;
	}
	public static void setDownloadCompressedFilePath(String downloadCompressedFilePath) {
		CommonData.downloadCompressedFilePath = downloadCompressedFilePath;
	}
	public static String getDownloadDecompressedFilePath() {
		return downloadDecompressedFilePath;
	}
	public static void setDownloadDecompressedFilePath(String downloadDecompressedFilePath) {
		CommonData.downloadDecompressedFilePath = downloadDecompressedFilePath;
	}
	public static String getDownloadCompressedFileName() {
		return downloadCompressedFileName;
	}
	public static void setDownloadCompressedFileName(String downloadCompressedFileName) {
		CommonData.downloadCompressedFileName = downloadCompressedFileName;
	}
	public static String getDownloadDecompressedFileName() {
		return downloadDecompressedFileName;
	}
	public static void setDownloadDecompressedFileName(String downloadDecompressedFileName) {
		CommonData.downloadDecompressedFileName = downloadDecompressedFileName;
	}
	
	
}
