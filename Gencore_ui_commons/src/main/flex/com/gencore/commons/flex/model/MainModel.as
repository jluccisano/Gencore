package com.gencore.commons.flex.model {
    import com.gencore.commons.flex.vo.UserProfileVO;
    
    import mx.collections.ArrayCollection;
    import mx.formatters.DateFormatter;


    public class MainModel {
		
        private static var _instance : MainModel;
		
		[Bindable]
		public var dateFormat : DateFormatter;

        public static function get instance() : MainModel {
            if (_instance == null) {
                _instance = new MainModel();
            }
            return _instance;
        }

        public function MainModel() {
            if (_instance != null) {
                throw new Error("Only one Model instance should be instantiated");
            }
			
			dateFormat = new DateFormatter ();
			dateFormat.formatString = 'DD/MM/YYYY';
        }

        [Bindable] public static var ENDPOINT : String;
        [Bindable] public static var GMAPSKEY : String;
		[Bindable] public static var VERSION : String;

        public static const LOGIN_MODULE : String = "gencore_ui_login.swf";
        public static const ADMIN_MODULE : String = "gencore_ui_admin.swf";
        public static const TRACKER_MODULE : String = "gencore_ui_tracker.swf";
		public static const HOME_MODULE : String = "gencore_ui_home.swf";
		


        private var _connected : Boolean = false;

        public function set connected(value : Boolean) : void {
            _connected = value;

            if (!_connected)
                _userConnected = null;
        }

        [Bindable] public function get connected() : Boolean {
            return _connected;
        }



        private var _userConnected : UserProfileVO;

        [Bindable] public function get userConnected() : UserProfileVO {
            return _userConnected;
        }

        public function set userConnected(value : UserProfileVO) : void {
            _userConnected = value;
        }
    }
}