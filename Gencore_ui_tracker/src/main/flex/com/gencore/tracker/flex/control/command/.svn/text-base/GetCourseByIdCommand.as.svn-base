package com.gencore.tracker.flex.control.command {

  
    

    import com.gencore.commons.flex.manager.ErrorManager;
    import com.gencore.tracker.flex.business.TrackerDelegate;
    import com.gencore.tracker.flex.control.event.TrackerEvent;
    
    import mx.controls.Alert;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;


    public class GetCourseByIdCommand extends Command implements IResponder {
        private var trackerEvent : TrackerEvent;

        override protected function execute(event : LucciEvent) : void {

            trackerEvent = TrackerEvent(event);

            super.execute(trackerEvent);

            var delegate : TrackerDelegate = new TrackerDelegate(this);

            delegate.getCourseById(trackerEvent.data["courseId"]);

        }

        override public function result(data : Object) : void {

            var event : ResultEvent = data as ResultEvent;

            LucciEventDispatcher.instance.dispatchEvent(new TrackerEvent(TrackerEvent.GET_COURSE_ACK, event.result));
        }

        override public function fault(data : Object) : void {

            var faultEvt : FaultEvent = data as FaultEvent;

            Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode));


        }
    }
}