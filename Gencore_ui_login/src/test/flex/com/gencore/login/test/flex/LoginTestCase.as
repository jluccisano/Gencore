package com.gencore.login.test.flex {
    import com.gencore.commons.flex.vo.UserProfileVO;
    import com.gencore.login.flex.business.LoginDelegate;

    import flexunit.framework.Assert;

    import mx.rpc.AsyncToken;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;

    import org.flexunit.async.Async;
    import org.flexunit.async.TestResponder;

    public class LoginTestCase {

        private var delegate : LoginDelegate;

        [Before(async)]
        public function setUp() : void {


        }

        [Test(async)]
        public function testLoginDelegate() : void {

            var responder : IResponder = Async.asyncResponder(this, new TestResponder(handleResult, handleFault), 3000);

            delegate = new LoginDelegate(responder);

            delegate.getConnection('admin', 'password');
        }

        public function testLoginDelegateFalse() : void {

            var responder : IResponder = Async.asyncResponder(this, new TestResponder(handleResult, handleFault), 3000);

            delegate = new LoginDelegate(responder);

            delegate.getConnection('admink', 'password');
        }


        protected function handleResult(event : ResultEvent, token : AsyncToken) : void {

            Assert.assertTrue("Result is what i want it to be", event.result is UserProfileVO);
        }

        protected function handleFault(event : FaultEvent, token : AsyncToken) : void {

            Assert.fail("Unintended fault from service");
        }

    }
}