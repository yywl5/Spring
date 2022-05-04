package Controllers.wyl.APIs;;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件下载
 */
@Controller
public class FileDownloadController {
	// 文件下载（不支持中文文件名下载）
	@RequestMapping("/download1")
	public ResponseEntity<byte[]> fileDownload1(HttpServletRequest request,
												String fileName) throws Exception{
		//因为请求方式是get，所以字符编码过滤器中设置的字符集不起作用，所以需要通过编码来转码，也可以通过Tomcat的配置文件server.xml中 URIEncoding="UTF-8" 来解决
		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		// 指定要下载的文件所在路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 创建该文件对象
		System.out.println("下载的文件名：" + path + File.separator + fileName);
		File file = new File(path + File.separator + fileName);
		// 设置响应头
		HttpHeaders headers = new HttpHeaders();
		// 通知浏览器以下载的方式打开文件
		headers.setContentDispositionFormData("attachment", fileName);
		// 定义以流的形式下载返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers,HttpStatus.OK);
	}

	// 文件下载（教材的写法）
	@RequestMapping("/download2")
	public void fileDownload2(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
		//因为请求方式是get，所以字符编码过滤器中设置的字符集不起作用，所以需要通过编码来转码，也可以通过Tomcat的配置文件server.xml中 URIEncoding="UTF-8" 来解决
		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		File file = new File(request.getSession().getServletContext().getRealPath("/upload/"), fileName);
		System.out.println("文件名：" + file.getAbsolutePath());
		byte[] data = FileUtils.readFileToByteArray(file);
		response.setContentType("application/x-msdownload;");
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(file.getName().getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.getOutputStream().write(data);
	}

	// 文件下载（支持中文文件名下载）
	@RequestMapping("/download3")
	public ResponseEntity<byte[]> fileDownload3(HttpServletRequest request, String fileName) throws Exception {
		//因为请求方式是get，所以字符编码过滤器中设置的字符集不起作用，所以需要通过编码来转码，也可以通过Tomcat的配置文件server.xml中 URIEncoding="UTF-8" 来解决
		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		// 指定要下载的文件所在路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 创建该文件对象
		System.out.println("下载的文件名：" + path + File.separator + fileName);
		File file = new File(path + File.separator + fileName);
		// 对文件名编码，防止中文文件乱码
		fileName = this.getFilename(request, fileName);
		// 设置响应头
		HttpHeaders headers = new HttpHeaders();
		// 通知浏览器以下载的方式打开文件
		//attachment
		headers.setContentDispositionFormData("attachment", fileName);
		//inline（默认）
		//headers.setContentDispositionFormData("inline", fileName);
		// 定义以流的形式下载返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	// 下载后直接打开文件
	@RequestMapping("/download4")
	public ResponseEntity<byte[]> fileDownload4(HttpServletRequest request, String fileName) throws Exception {
		//因为请求方式是get，所以字符编码过滤器中设置的字符集不起作用，所以需要通过编码来转码，也可以通过Tomcat的配置文件server.xml中 URIEncoding="UTF-8" 来解决
		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");
		// 指定要下载的文件所在路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 创建该文件对象
		System.out.println("下载的文件名：" + path + File.separator + fileName);
		File file = new File(path + File.separator + fileName);
		// 对文件名编码，防止中文文件乱码
		fileName = this.getFilename(request, fileName);
		// 设置响应头
		HttpHeaders headers = new HttpHeaders();
		//inline（默认）
		headers.setContentDispositionFormData("inline", fileName);
		// 定义以流的形式下载返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	/**
	 * 根据浏览器的不同进行编码设置，返回编码后的文件名
	 */
	public String getFilename(HttpServletRequest request, String fileName) throws Exception {
		// IE不同版本User-Agent中出现的关键词
		String[] IEBrowserKeyWords = { "MSIE", "Trident", "Edge" };
		// 获取请求头代理信息
		String userAgent = request.getHeader("User-Agent");
		for (String keyWord : IEBrowserKeyWords) {
			if (userAgent.contains(keyWord)) {
				// IE内核浏览器，统一为UTF-8编码显示
				return URLEncoder.encode(fileName, "UTF-8");
			}
		}
		// 火狐等其它浏览器统一为ISO-8859-1编码显示
		return new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	}

}
