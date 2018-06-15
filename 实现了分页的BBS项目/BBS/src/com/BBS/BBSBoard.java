package com.BBS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Statement;

public class BBSBoard {
	public List<Article> articles=new ArrayList<Article>();
	public int curPage=1;
	public int allPage;
	public int artPerPage=20;
	private Connection conn=DB.getCon();
	public BBSBoard() {
		tree(articles,conn,0,0);
		this.allPage=(articles.size()+artPerPage-1)/artPerPage;
	}
	public BBSBoard(int artPerPage) {
		this.artPerPage=artPerPage;
		tree(articles,conn,0,0);
		this.allPage=(articles.size()+artPerPage-1)/artPerPage;
	}
	public List<Article> getPage(int page){
		List<Article> ret=new ArrayList<Article>();
		for(int i=(page-1)*artPerPage;i<artPerPage*page&&i<articles.size();i++) {
			Article a=articles.get(i);
			ret.add(a);
		}
		return ret;
	}
	
	private void tree(List<Article> articles,Connection conn,int id,int grade) { 
		String sql="select * from article where pid="+id;
		Statement stmt=DB.createStmt(conn);
		ResultSet rs=DB.executeQuery(stmt, sql);
		try{
			while(rs.next()){
				Article a=new Article();
				a.setId(rs.getInt("id"));
				a.setPid(rs.getInt("pid"));
				a.setRootId(rs.getInt("rootid"));
				a.setTitle(rs.getString("title"));
				a.setLeaf(rs.getInt("isleaf")==0?true:false);
				a.setPdate(rs.getDate("pdate"));
				a.setAuthor(rs.getString("author"));
				a.setGrade(grade);
				articles.add(a);
				/*if(!a.isLeaf()){
					tree(articles,conn,a.getId(),grade+1);
				}*/
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.close(conn);
		}
		
	}
}
