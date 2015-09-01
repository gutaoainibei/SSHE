package sy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xpath.internal.operations.Gte;

import java.io.*;

import org.apache.struts2.ServletActionContext;


public class UploadAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 16*1024;
	// 封装文件标题请求参数的属性
	private String title;
	// 封装上传文件域的属性
	private File upload;
	// 封装上传文件类型的属性
	private String uploadContentType;
	// 封装上传文件名的属性
	private String uploadFileName;
	// 直接在struts.xml文件中配置的属性
	private String savePath;
	// 接受struts.xml文件配置值的方法


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
		System.out.println("title======"+title);
	}


	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
		
	}


	public String getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
		System.out.println("uploadContentType======"+uploadContentType);
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
		System.out.println("uploadFileName======"+uploadFileName);
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
		System.out.println("savepath:"+savePath);
	}
	
	@Override
	public String execute() throws Exception {
		FileOutputStream fos = new FileOutputStream(getSavePath()
			+ "\\" + getUploadFileName());
		System.out.println("开始執行了execute");
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer , 0 , len);
		}
		fos.close();
		System.out.println("執行完了execute");
		return SUCCESS;
	}
	public String exe(){
		FileInputStream in=null;
		FileOutputStream out=null;
		try {
			in=new FileInputStream(getUpload());
			System.out.println("執行了execute3");
			out=new FileOutputStream(getSavePath()
					+ "\\" + getUploadFileName());
			System.out.println("執行了execute4");
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0)
			{
				out.write(buffer , 0 , len);
			}
		     in.close();
		     out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("執行了execute2222222222222");
		return SUCCESS;
		
		
	}
	public String pri(){
		String sourpath=ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"\\"+ getUploadFileName();
		System.out.println(sourpath);
		File outfile=new File(sourpath);
		System.out.println("執行了execute1");
		copy(this.upload,outfile);
		System.out.println("執行了execute2");
		System.out.println("執行了execute2222222222222");
		return SUCCESS;
	}
	public void copy(File upfile, File outfile) {
		InputStream in=null;
		OutputStream out=null;
		try {
			in=new BufferedInputStream(new FileInputStream(upfile),BUFFER_SIZE );
			out=new BufferedOutputStream(new FileOutputStream(outfile), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0)
			{
				out.write(buffer , 0 , len);
			}
		     in.close();
		     out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}