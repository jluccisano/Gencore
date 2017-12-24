package com.gencore.portal.test.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;
import com.thoughtworks.selenium.Selenium;

public class LoginModuleTest {
    private Selenium selenium;
    private HttpCommandProcessor proc;

    @Before
    public void setUp() throws Exception {

        proc = new HttpCommandProcessor("localhost", 4444, "*firefox /usr/lib/firefox-3.6.12/firefox-bin", "http://localhost:8083/");
        selenium = new DefaultSelenium(proc);
        selenium.start();
    }

    @After
    public void tearDown() throws Exception {
        if (selenium != null) {
            selenium.stop();
            selenium = null;
        }
    }

    @Test
    public void myTestMethod() throws Exception {
        selenium.open("/Gencore_portal/gencore_portal.html#/login");
        proc
                .doCommand(
                        "flexMonkey",
                        new String[] {
                                                "<UIEvent command=\"SelectText\" value=\"login_ti\" prop=\"automationName\"><arg value=\"0\"/><arg value=\"0\"/></UIEvent>",
                                                "" });
        proc
                .doCommand(
                        "flexMonkey",
                        new String[] {
                                                "<UIEvent command=\"Input\" value=\"login_ti\" prop=\"automationName\"><arg value=\"Joseph\"/></UIEvent>",
                                                "" });
        proc.doCommand("flexMonkey", new String[] {
                                "<UIEvent command=\"ChangeFocus\" value=\"login_ti\" prop=\"automationName\"/>", "" });
        proc
                .doCommand(
                        "flexMonkey",
                        new String[] {
                                                "<UIEvent command=\"Input\" value=\"password_ti\" prop=\"automationName\"><arg value=\"Luccisano\"/></UIEvent>",
                                                "" });
        proc.doCommand("flexMonkey", new String[] {
                                "<UIEvent command=\"Click\" value=\"se connecter\" prop=\"automationName\"/>", "" });
        proc.doCommand("flexMonkey", new String[] {
                                "<UIEvent command=\"Click\" value=\"OK\" prop=\"automationName\"/>", "" });
    }
}
