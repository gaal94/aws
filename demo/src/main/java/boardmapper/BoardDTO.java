package boardmapper;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	int seq;
	String title, contents, writer;
	int pw, viewcount;
	String writingtime, file1;
	MultipartFile multifile1;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public MultipartFile getMultifile1() {
		return multifile1;
	}
	public void setMultifile1(MultipartFile multifile1) {
		this.multifile1 = multifile1;
	}
	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", pw="
				+ pw + ", viewcount=" + viewcount + ", writingtime=" + writingtime + ", file1=" + file1 + "]";
	}
	
}
