package com.jiang.servlet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.jiang.pojo.Book;
import com.jiang.pojo.Category;
import com.jiang.service.BookService;
import com.jiang.service.CategoryService;
import com.jiang.service.impl.BookServiceImpl;
import com.jiang.service.impl.CategoryImpl;
import com.jiang.util.Page;

public class CategoryServlet extends HttpServlet{

	private CategoryService Service = new CategoryImpl();
	
	private BookService BookService = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println(req);
	     String op = req.getParameter("op");
		 String name = req.getParameter("name");
		 String description = req.getParameter("description");
		 
		if (op.equals("add")) {
			Category category = new Category();
			category.setName(name);
			category.setDescription(description);
			Service.addCategory(category);
		
			resp.sendRedirect(req.getContextPath()+"/manage/addcategory.jsp");
		}else if (op.equals("find")) {
			List<Category> list = Service.findAllCategory();
			req.setAttribute("list", list);
			System.out.println("lllllllllllllll");
			req.getRequestDispatcher("/manage/findCategory.jsp").forward(req, resp);
		}else if (op.equals("find_addbook")) {
			List<Category> list = Service.findAllCategory();
			req.setAttribute("list", list);
			System.out.println("lllllllllllllll");
			req.getRequestDispatcher("/manage/addbook.jsp").forward(req, resp);
		}else if (op.equals("addBook")) {
			
			boolean ismutable =  ServletFileUpload.isMultipartContent(req);
			if (!ismutable) {
				
				throw new RuntimeException();
			}
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sFileUpload = new ServletFileUpload(factory);
			List<FileItem> items = new ArrayList<FileItem>();
			
			try {
				items =  sFileUpload.parseRequest(req);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			Book book = new Book();
			
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				if (item.isFormField()) {
					String key = item.getFieldName();//name
					String value = item.getString("utf-8");
					if (key.equals("categoryId")) {
						Category category = Service.findCategoryById(value);
						book.setCategory(category);
					}
					try {
						
						BeanUtils.setProperty(book, key, value);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}else {
					
					String storeDirector =	getServletContext().getRealPath("images");
				
					File rootDir = new File(storeDirector);
					if (!rootDir.exists()) {
						rootDir.mkdirs();
					}
				
				
					String filename = item.getName();
					
					if (filename != null) {
						filename = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(filename);
					
						book.setFilename(filename);
						
						String path = genChildDirectory(storeDirector);
						
						book.setPath(path);
						
						try {
							item.write(new File(storeDirector,path +"/" + filename));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
				}
			}
			
			
			BookService.saveBook(book);
			
		}else if (op.equals("showbook")) {
			String num = req.getParameter("num");
			Page page = BookService.findBookPageRecords(num);
			req.setAttribute("page", page);
			
			
			req.getRequestDispatcher("/manage/list.jsp").forward(req, resp);
		}
		System.out.println(req.getParameter("op"));
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
	
	private String genChildDirectory(String realpath)
	{
		Date now = new Date();
		DateFormat dFormat = new SimpleDateFormat("yyyy-mm-dd");
		String str = dFormat.format(now);
		
		File file = new File(realpath,str);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		return str;
		
	}

}
