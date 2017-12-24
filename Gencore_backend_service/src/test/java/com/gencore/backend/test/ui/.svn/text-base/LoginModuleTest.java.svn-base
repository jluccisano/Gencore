package com.gencore.backend.test.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gencore.backend.test.BaseTest;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;
import com.thoughtworks.selenium.Selenium;

public class LoginModuleTest extends BaseTest {
    private Selenium selenium;
    private HttpCommandProcessor proc;

    @Before
    public void setUp() throws Exception {
        proc = new HttpCommandProcessor("localhost", 4444, "*chrome", "http://localhost:8080/");
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
        selenium.open("/Gencore_portal/flex/gencore_ui_portal.html#/login");
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
