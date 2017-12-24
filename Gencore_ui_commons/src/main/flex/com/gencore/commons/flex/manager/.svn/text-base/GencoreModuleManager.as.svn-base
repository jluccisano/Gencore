package com.gencore.commons.flex.manager {

    import flash.system.System;
    
    import mx.events.ModuleEvent;
    import mx.modules.ModuleLoader;

    public class GencoreModuleManager {
		
        private static var _instance : GencoreModuleManager;

        public static function get instance() : GencoreModuleManager {
            if (_instance == null) {
                _instance = new GencoreModuleManager();
            }
            return _instance;
        }

        public function GencoreModuleManager() {
            if (_instance != null) {
                throw new Error("Only one ModelManager instance should be instantiated");
            }

        }

        public var moduleLoader : ModuleLoader;

        public function loadModule(url : String) : void {

            if (moduleLoader != null && url != moduleLoader.url) {
                moduleLoader.url = "";
                moduleLoader.unloadModule();
                this.addEventListeners();
                moduleLoader.loadModule(url);
            }
        }

        public function unloadModule(url : String) : void {
            if (moduleLoader != null && url == moduleLoader.url) {
				
				//var g:* = moduleLoader.child;	
				//g.unloadThisModule();
				//removeChild(moduleLoader);

                moduleLoader.url = "";
                moduleLoader.unloadModule();
				System.gc(); 
            }

        }

        private function addEventListeners() : void {

            moduleLoader.addEventListener(ModuleEvent.PROGRESS, onProgressEvent, false, 0, true);
            moduleLoader.addEventListener(ModuleEvent.READY, onReadyEvent, false, 0, true);
            moduleLoader.addEventListener(ModuleEvent.ERROR, onErrorEvent, false, 0, true);
        }

        private function removeEventListeners() : void {

            moduleLoader.removeEventListener(ModuleEvent.PROGRESS, onProgressEvent);
            moduleLoader.removeEventListener(ModuleEvent.READY, onReadyEvent);
            moduleLoader.removeEventListener(ModuleEvent.ERROR, onErrorEvent);
        }

        public function onProgressEvent(event : ModuleEvent) : void {

        }

        public function onReadyEvent(event : ModuleEvent) : void {
            this.removeEventListeners();
        }

        public function onErrorEvent(event : ModuleEvent) : void {
            this.removeEventListeners();
        }

        public function getCurrentModule() : String {
            return this.moduleLoader.url;
        }
    }
}
