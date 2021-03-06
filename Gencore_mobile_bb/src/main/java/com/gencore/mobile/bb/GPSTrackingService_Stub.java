// This class was generated by 172 StubGenerator.
// Contents subject to change without notice.
// @generated

package com.gencore.mobile.bb;

import javax.xml.rpc.JAXRPCException;
import javax.xml.namespace.QName;
import javax.microedition.xml.rpc.Operation;
import javax.microedition.xml.rpc.Type;
import javax.microedition.xml.rpc.ComplexType;
import javax.microedition.xml.rpc.Element;

public class GPSTrackingService_Stub implements com.gencore.mobile.bb.GPSTrackingService, javax.xml.rpc.Stub {
	private String[] _propertyNames;
	private Object[] _propertyValues;

	public GPSTrackingService_Stub() {
		_propertyNames = new String[] {ENDPOINT_ADDRESS_PROPERTY};
		_propertyValues = new Object[] {"http://gencore.dyndns-server.com/Gencore_portal/ws/gpstracking"};
	}

	public void _setProperty(String name, Object value) {
		int size = _propertyNames.length;
		for (int i = 0; i < size; ++i) {
			if (_propertyNames[i].equals(name)) {
				_propertyValues[i] = value;
				return;
			}
		}
		// Need to expand our array for a new property
		String[] newPropNames = new String[size + 1];
		System.arraycopy(_propertyNames, 0, newPropNames, 0, size);
		_propertyNames = newPropNames;
		Object[] newPropValues = new Object[size + 1];
		System.arraycopy(_propertyValues, 0, newPropValues, 0, size);
		_propertyValues = newPropValues;

		_propertyNames[size] = name;
		_propertyValues[size] = value;
	}

	public Object _getProperty(String name) {
		for (int i = 0; i < _propertyNames.length; ++i) {
			if (_propertyNames[i].equals(name)) {
				return _propertyValues[i];
			}
		}
		if (ENDPOINT_ADDRESS_PROPERTY.equals(name) || USERNAME_PROPERTY.equals(name) || PASSWORD_PROPERTY.equals(name)) {
			return null;
		}
		if (SESSION_MAINTAIN_PROPERTY.equals(name)) {
			return new java.lang.Boolean(false);
		}
		throw new JAXRPCException("Stub does not recognize property: "+name);
	}

	protected void _prepOperation(Operation op) {
		for (int i = 0; i < _propertyNames.length; ++i) {
			op.setProperty(_propertyNames[i], _propertyValues[i].toString());
		}
	}

	// 
	//  Begin user methods
	// 

	public void sendGPSLocation(java.lang.String imei, com.gencore.mobile.bb.GPSLocationType gpsLocation) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[2];
		inputObject[0] = imei;
		Object[] GPSLocationTypeObject;
		if (gpsLocation == null) {
			GPSLocationTypeObject = null;
		} else {
			GPSLocationTypeObject = new Object[4];
			GPSLocationTypeObject[0] = new java.lang.Double(gpsLocation.getLattitude());
			GPSLocationTypeObject[1] = new java.lang.Double(gpsLocation.getLongitude());
			GPSLocationTypeObject[2] = new java.lang.Float(gpsLocation.getAltitude());
			GPSLocationTypeObject[3] = new java.lang.Long(gpsLocation.getTimestamp());
		}
		inputObject[1] = GPSLocationTypeObject;

		Operation op = Operation.newInstance(_qname_sendGPSLocation, _type_sendGPSLocationRequest, null);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		try {
			op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
	}

	public int registerDevice(java.lang.String username, java.lang.String password, java.lang.String imei) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[3];
		inputObject[0] = username;
		inputObject[1] = password;
		inputObject[2] = imei;

		Operation op = Operation.newInstance(_qname_RegisterDevice, _type_RegisterDeviceRequest, _type_RegisterDeviceResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		int result;
		// Convert the result into the right Java type.
		// Unwrapped return value
		Object statusObj = ((Object[])resultObj)[0];
		result = ((java.lang.Integer)statusObj).intValue();
		return result;
	}

	public com.gencore.mobile.bb.StartTrackingResponse startTracking(long startDate, java.lang.String imei) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[2];
		inputObject[0] = new java.lang.Long(startDate);
		inputObject[1] = imei;

		Operation op = Operation.newInstance(_qname_startTracking, _type_startTrackingRequest, _type_startTrackingResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		com.gencore.mobile.bb.StartTrackingResponse result;
		// Convert the result into the right Java type.
		if (resultObj == null) {
			result = null;
		} else {
			result = new com.gencore.mobile.bb.StartTrackingResponse();
			java.lang.String string;
			Object runIdObj = ((Object[])resultObj)[0];
			string = (java.lang.String)runIdObj;
			result.setRunId(string);
			int a_int;
			Object statusObj = ((Object[])resultObj)[1];
			a_int = ((java.lang.Integer)statusObj).intValue();
			result.setStatus(a_int);
		}
		return result;
	}

	public com.gencore.mobile.bb.StopTrackingResponse stopTracking(java.lang.String runId, java.lang.Long endDate, java.lang.String imei, com.gencore.mobile.bb.GPSLocationArray gpsLocations) throws java.rmi.RemoteException {
		// Copy the incoming values into an Object array if needed.
		Object[] inputObject = new Object[4];
		inputObject[0] = runId;
		inputObject[1] = endDate;
		inputObject[2] = imei;
		Object[] GPSLocationArrayObject;
		if (gpsLocations == null) {
			GPSLocationArrayObject = null;
		} else {
			Object[] GPSLocationTypeArrayObject;
			if (gpsLocations.getGpsLocations() == null) {
				GPSLocationTypeArrayObject = new Object[0];
			} else {
				GPSLocationTypeArrayObject = new Object[gpsLocations.getGpsLocations().length];
				for (int GPSLocationTypeArrayIndex = 0; 
					GPSLocationTypeArrayIndex < gpsLocations.getGpsLocations().length; 
					++GPSLocationTypeArrayIndex) {
					Object[] GPSLocationTypeObject;
					if (gpsLocations.getGpsLocations()[GPSLocationTypeArrayIndex] == null) {
						GPSLocationTypeObject = null;
					} else {
						GPSLocationTypeObject = new Object[4];
						GPSLocationTypeObject[0] = new java.lang.Double(gpsLocations.getGpsLocations()[GPSLocationTypeArrayIndex].getLattitude());
						GPSLocationTypeObject[1] = new java.lang.Double(gpsLocations.getGpsLocations()[GPSLocationTypeArrayIndex].getLongitude());
						GPSLocationTypeObject[2] = new java.lang.Float(gpsLocations.getGpsLocations()[GPSLocationTypeArrayIndex].getAltitude());
						GPSLocationTypeObject[3] = new java.lang.Long(gpsLocations.getGpsLocations()[GPSLocationTypeArrayIndex].getTimestamp());
					}

					GPSLocationTypeArrayObject[GPSLocationTypeArrayIndex] = GPSLocationTypeObject;
				}
			}
			GPSLocationArrayObject = new Object[1];
			GPSLocationArrayObject[0] = GPSLocationTypeArrayObject;
		}
		inputObject[3] = GPSLocationArrayObject;

		Operation op = Operation.newInstance(_qname_stopTracking, _type_stopTrackingRequest, _type_stopTrackingResponse);
		_prepOperation(op);
		op.setProperty(Operation.SOAPACTION_URI_PROPERTY, "");
		Object resultObj;
		try {
			resultObj = op.invoke(inputObject);
		} catch (JAXRPCException e) {
			Throwable cause = e.getLinkedCause();
			if (cause instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) cause;
			}
			throw e;
		}
		com.gencore.mobile.bb.StopTrackingResponse result;
		// Convert the result into the right Java type.
		if (resultObj == null) {
			result = null;
		} else {
			result = new com.gencore.mobile.bb.StopTrackingResponse();
			java.lang.String string;
			Object runIdObj = ((Object[])resultObj)[0];
			string = (java.lang.String)runIdObj;
			result.setRunId(string);
			int a_int;
			Object statusObj = ((Object[])resultObj)[1];
			a_int = ((java.lang.Integer)statusObj).intValue();
			result.setStatus(a_int);
		}
		return result;
	}
	// 
	//  End user methods
	// 

	protected static final QName _qname_RegisterDevice = new QName("http://gencore.com/ws/gpstracking/schemas", "RegisterDevice");
	protected static final QName _qname_RegisterDeviceRequest = new QName("http://gencore.com/ws/gpstracking/schemas", "RegisterDeviceRequest");
	protected static final QName _qname_RegisterDeviceResponse = new QName("http://gencore.com/ws/gpstracking/schemas", "RegisterDeviceResponse");
	protected static final QName _qname_altitude = new QName("http://gencore.com/ws/gpstracking/schemas", "altitude");
	protected static final QName _qname_endDate = new QName("http://gencore.com/ws/gpstracking/schemas", "endDate");
	protected static final QName _qname_gpsLocation = new QName("http://gencore.com/ws/gpstracking/schemas", "gpsLocation");
	protected static final QName _qname_gpsLocations = new QName("http://gencore.com/ws/gpstracking/schemas", "gpsLocations");
	protected static final QName _qname_imei = new QName("http://gencore.com/ws/gpstracking/schemas", "imei");
	protected static final QName _qname_lattitude = new QName("http://gencore.com/ws/gpstracking/schemas", "lattitude");
	protected static final QName _qname_longitude = new QName("http://gencore.com/ws/gpstracking/schemas", "longitude");
	protected static final QName _qname_password = new QName("http://gencore.com/ws/gpstracking/schemas", "password");
	protected static final QName _qname_runId = new QName("http://gencore.com/ws/gpstracking/schemas", "runId");
	protected static final QName _qname_sendGPSLocation = new QName("http://gencore.com/ws/gpstracking/schemas", "sendGPSLocation");
	protected static final QName _qname_sendGPSLocationRequest = new QName("http://gencore.com/ws/gpstracking/schemas", "sendGPSLocationRequest");
	protected static final QName _qname_startDate = new QName("http://gencore.com/ws/gpstracking/schemas", "startDate");
	protected static final QName _qname_startTracking = new QName("http://gencore.com/ws/gpstracking/schemas", "startTracking");
	protected static final QName _qname_startTrackingRequest = new QName("http://gencore.com/ws/gpstracking/schemas", "startTrackingRequest");
	protected static final QName _qname_startTrackingResponse = new QName("http://gencore.com/ws/gpstracking/schemas", "startTrackingResponse");
	protected static final QName _qname_status = new QName("http://gencore.com/ws/gpstracking/schemas", "status");
	protected static final QName _qname_stopTracking = new QName("http://gencore.com/ws/gpstracking/schemas", "stopTracking");
	protected static final QName _qname_stopTrackingRequest = new QName("http://gencore.com/ws/gpstracking/schemas", "stopTrackingRequest");
	protected static final QName _qname_stopTrackingResponse = new QName("http://gencore.com/ws/gpstracking/schemas", "stopTrackingResponse");
	protected static final QName _qname_timestamp = new QName("http://gencore.com/ws/gpstracking/schemas", "timestamp");
	protected static final QName _qname_username = new QName("http://gencore.com/ws/gpstracking/schemas", "username");
	protected static final Element _type_sendGPSLocationRequest;
	protected static final Element _type_RegisterDeviceRequest;
	protected static final Element _type_RegisterDeviceResponse;
	protected static final Element _type_startTrackingRequest;
	protected static final Element _type_startTrackingResponse;
	protected static final Element _type_stopTrackingRequest;
	protected static final Element _type_stopTrackingResponse;
	static {
		// Create all of the Type's that this stub uses, once.
		Element _type_imei;
		_type_imei = new Element(_qname_imei, Type.STRING);
		Element _type_lattitude;
		_type_lattitude = new Element(_qname_lattitude, Type.DOUBLE);
		Element _type_longitude;
		_type_longitude = new Element(_qname_longitude, Type.DOUBLE);
		Element _type_altitude;
		_type_altitude = new Element(_qname_altitude, Type.FLOAT);
		Element _type_timestamp;
		_type_timestamp = new Element(_qname_timestamp, Type.LONG);
		ComplexType _complexType_GPSLocationType;
		_complexType_GPSLocationType = new ComplexType();
		_complexType_GPSLocationType.elements = new Element[4];
		_complexType_GPSLocationType.elements[0] = _type_lattitude;
		_complexType_GPSLocationType.elements[1] = _type_longitude;
		_complexType_GPSLocationType.elements[2] = _type_altitude;
		_complexType_GPSLocationType.elements[3] = _type_timestamp;
		Element _type_gpsLocation;
		_type_gpsLocation = new Element(_qname_gpsLocation, _complexType_GPSLocationType);
		ComplexType _complexType_sendGPSLocationRequest;
		_complexType_sendGPSLocationRequest = new ComplexType();
		_complexType_sendGPSLocationRequest.elements = new Element[2];
		_complexType_sendGPSLocationRequest.elements[0] = _type_imei;
		_complexType_sendGPSLocationRequest.elements[1] = _type_gpsLocation;
		_type_sendGPSLocationRequest = new Element(_qname_sendGPSLocationRequest, _complexType_sendGPSLocationRequest);
		Element _type_username;
		_type_username = new Element(_qname_username, Type.STRING);
		Element _type_password;
		_type_password = new Element(_qname_password, Type.STRING);
		ComplexType _complexType_registerDeviceRequest;
		_complexType_registerDeviceRequest = new ComplexType();
		_complexType_registerDeviceRequest.elements = new Element[3];
		_complexType_registerDeviceRequest.elements[0] = _type_username;
		_complexType_registerDeviceRequest.elements[1] = _type_password;
		_complexType_registerDeviceRequest.elements[2] = _type_imei;
		_type_RegisterDeviceRequest = new Element(_qname_RegisterDeviceRequest, _complexType_registerDeviceRequest);
		Element _type_status;
		_type_status = new Element(_qname_status, Type.INT);
		ComplexType _complexType_registerDeviceResponse;
		_complexType_registerDeviceResponse = new ComplexType();
		_complexType_registerDeviceResponse.elements = new Element[1];
		_complexType_registerDeviceResponse.elements[0] = _type_status;
		_type_RegisterDeviceResponse = new Element(_qname_RegisterDeviceResponse, _complexType_registerDeviceResponse);
		Element _type_startDate;
		_type_startDate = new Element(_qname_startDate, Type.LONG);
		ComplexType _complexType_startTrackingRequest;
		_complexType_startTrackingRequest = new ComplexType();
		_complexType_startTrackingRequest.elements = new Element[2];
		_complexType_startTrackingRequest.elements[0] = _type_startDate;
		_complexType_startTrackingRequest.elements[1] = _type_imei;
		_type_startTrackingRequest = new Element(_qname_startTrackingRequest, _complexType_startTrackingRequest);
		Element _type_runId;
		_type_runId = new Element(_qname_runId, Type.STRING);
		ComplexType _complexType_startTrackingResponse;
		_complexType_startTrackingResponse = new ComplexType();
		_complexType_startTrackingResponse.elements = new Element[2];
		_complexType_startTrackingResponse.elements[0] = _type_runId;
		_complexType_startTrackingResponse.elements[1] = _type_status;
		_type_startTrackingResponse = new Element(_qname_startTrackingResponse, _complexType_startTrackingResponse);
		Element _type_runId2;
		_type_runId2 = new Element(_qname_runId, Type.STRING, 0, 1, false);
		Element _type_endDate;
		_type_endDate = new Element(_qname_endDate, Type.LONG, 0, 1, false);
		Element _type_imei2;
		_type_imei2 = new Element(_qname_imei, Type.STRING, 0, 1, false);
		Element _type_gpsLocations;
		_type_gpsLocations = new Element(_qname_gpsLocations, _complexType_GPSLocationType, 0, -1, true);
		ComplexType _complexType_GPSLocationArray;
		_complexType_GPSLocationArray = new ComplexType();
		_complexType_GPSLocationArray.elements = new Element[1];
		_complexType_GPSLocationArray.elements[0] = _type_gpsLocations;
		Element _type_gpsLocations2;
		_type_gpsLocations2 = new Element(_qname_gpsLocations, _complexType_GPSLocationArray, 0, 1, false);
		ComplexType _complexType_stopTrackingRequest;
		_complexType_stopTrackingRequest = new ComplexType();
		_complexType_stopTrackingRequest.elements = new Element[4];
		_complexType_stopTrackingRequest.elements[0] = _type_runId2;
		_complexType_stopTrackingRequest.elements[1] = _type_endDate;
		_complexType_stopTrackingRequest.elements[2] = _type_imei2;
		_complexType_stopTrackingRequest.elements[3] = _type_gpsLocations2;
		_type_stopTrackingRequest = new Element(_qname_stopTrackingRequest, _complexType_stopTrackingRequest);
		_type_stopTrackingResponse = new Element(_qname_stopTrackingResponse, _complexType_startTrackingResponse);
	}

}
