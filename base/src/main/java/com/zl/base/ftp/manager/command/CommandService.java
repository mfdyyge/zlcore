package com.dc.ftp.manager.command;

public interface CommandService {
	public String doExec(String command);
	public String help();
}
