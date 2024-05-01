package com.marketplace.brand.models;

import com.marketplace.brand.model.Brand;

// for the document related operation we created document model
public class DocumentModel {

	private String uploadedDocName;
	private String downloadDocumentLink;
	private String fileEntryId;
	private Brand brand;
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getUploadedDocName() {
		return uploadedDocName;
	}
	public void setUploadedDocName(String uploadedDocName) {
		this.uploadedDocName = uploadedDocName;
	}
	public String getDownloadDocumentLink() {
		return downloadDocumentLink;
	}
	public void setDownloadDocumentLink(String downloadDocumentLink) {
		this.downloadDocumentLink = downloadDocumentLink;
	}
	public String getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	
	@Override
	public String toString() {
		return "DocumentModel [uploadedDocName=" + uploadedDocName + ", downloadDocumentLink=" + downloadDocumentLink
				+ ", fileEntryId=" + fileEntryId + "]";
	}
	
}
