package annotation.springmvc.upload;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {
	String uploader, desc;
	MultipartFile f1, f2;
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getF1() {
		return f1;
	}
	public void setF1(MultipartFile f1) {
		this.f1 = f1;
	}
	public MultipartFile getF2() {
		return f2;
	}
	public void setF2(MultipartFile f2) {
		this.f2 = f2;
	}
}
