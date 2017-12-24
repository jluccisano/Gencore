package com.gencore.commons.flex.vo
{
	import flash.utils.ByteArray;

	[Bindable]
	[RemoteClass(alias="com.gencore.backend.java.entity.UserProfile")]
	public class UserProfileVO
	{
		

		
		public var id : Number;
		public var login : String;
		public var password : String;
		public var enabled : Boolean;
		public var firstName : String;
		public var lastName : String;
		public var language : String;
		public var email : String;
		public var creationDate : Date;
		public var lastAccessDate : Date;
		public var role : UserRoleVO;
		public var locked : Boolean;
		public var photo : ByteArray;

	}
}