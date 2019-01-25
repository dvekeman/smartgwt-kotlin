package com.smartgwt.sample.server.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isomorphic.servlet.IDACall;

public class CustomIDACall extends IDACall {

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doHead...");
		super.doHead(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		super.doGet(request, response);
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doOptions...");
		super.doOptions(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...");
		super.doPost(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
}
