// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package com.gencore.mobile.bb;


public class RegisterDeviceRequest {
    protected java.lang.String username;
    protected java.lang.String password;
    protected java.lang.String imei;
    
    public RegisterDeviceRequest() {
    }
    
    public RegisterDeviceRequest(java.lang.String username, java.lang.String password, java.lang.String imei) {
        this.username = username;
        this.password = password;
        this.imei = imei;
    }
    
    public java.lang.String getUsername() {
        return username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getPassword() {
        return password;
    }
    
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    
    public java.lang.String getImei() {
        return imei;
    }
    
    public void setImei(java.lang.String imei) {
        this.imei = imei;
    }
}
