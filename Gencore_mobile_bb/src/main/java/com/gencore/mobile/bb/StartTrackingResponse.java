// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package com.gencore.mobile.bb;


public class StartTrackingResponse {
    protected java.lang.String runId;
    protected int status;
    
    public StartTrackingResponse() {
    }
    
    public StartTrackingResponse(java.lang.String runId, int status) {
        this.runId = runId;
        this.status = status;
    }
    
    public java.lang.String getRunId() {
        return runId;
    }
    
    public void setRunId(java.lang.String runId) {
        this.runId = runId;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
}
