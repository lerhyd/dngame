webpackJsonp([1],{"+dZy":function(t,e){},GY21:function(t,e,s){t.exports=s.p+"static/img/computer.8712d82.png"},NHnr:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=s("7+uW"),n=s("mtWM"),r=s.n(n),i=s("/ocq"),o={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[t._m(0),t._v(" "),s("p",[t._v("or")]),t._v(" "),s("form",{on:{submit:function(e){return e.preventDefault(),t.enter(e)}}},[s("label",{staticClass:"first_label"},[t._v("\n      Login:\n      "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.username,expression:"username"}],attrs:{type:"text"},domProps:{value:t.username},on:{input:function(e){e.target.composing||(t.username=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),s("label",{staticClass:"second_label"},[t._v("\n      Password:\n      "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),s("div",{staticClass:"forgot_link"},[s("router-link",{attrs:{to:"/recovery"}},[t._v("Forgot password?")])],1),t._v(" "),this.$store.getters.isFailed?s("p",{staticStyle:{color:"red"}},[t._v("Incorrect credentials")]):t._e(),t._v(" "),s("input",{staticClass:"sub",attrs:{type:"submit",value:"Log in"}})]),t._v(" "),s("div",{staticClass:"link"},[s("router-link",{attrs:{to:"/registry"}},[t._v("Sign up")])],1)])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"social"},[e("div",{staticClass:"google"},[e("img",{attrs:{src:s("likQ"),alt:"google"}}),this._v(" "),e("a",{attrs:{href:"http://localhost:1234/login/google"}},[this._v("LOG IN WITH GOOGLE")])]),this._v(" "),e("div",{staticClass:"vk"},[e("img",{attrs:{src:s("kubR"),alt:"vk"}}),this._v(" "),e("a",{attrs:{href:"http://localhost:1234/login/vk"}},[this._v("LOG IN WITH VKONTAKTE")])])])}]};var l={name:"Main",components:{Login:s("VU/8")({name:"Login",data:function(){return{username:"",password:""}},methods:{enter:function(){this.$store.dispatch("signIn",{username:this.username,password:this.password}).then()}}},o,!1,function(t){s("ZWcX")},"data-v-1cc131ba",null).exports}},c={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[this._m(0),this._v(" "),this._m(1),this._v(" "),e("section",{staticClass:"login_form"},[e("div",{staticClass:"container"},[e("Login")],1)]),this._v(" "),this._m(2)])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("header",[e("div",{staticClass:"container"},[e("img",{staticClass:"kira",attrs:{src:s("bTEt"),alt:"Kira"}}),this._v(" "),e("h1",[this._v("Death Note"),e("br"),this._v(" game")])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("section",{staticClass:"main"},[a("div",{staticClass:"container"},[a("div",{staticClass:"info_1"},[a("img",{attrs:{src:s("WJwM"),alt:"Note"}}),t._v(" "),a("p",[t._v("\n          В один прекрасный день ученик старшей школы случайно находит артефакт неизвестного происхождения: Тетрадь Смерти.\n          Тот, чьё имя будет записано в этой тетради, умрёт. С помощью неё подросток решил очистить общество от преступников.\n          Вскоре таинственные убийства потрясли мир. Никто не знал, почему люди умирают, но все понимали, что\n          за этим кто-то стоит. Люди назвали этого человека "),a("b",[t._v("Кирой")]),t._v("("),a("i",[t._v("от слова killer")]),t._v(").\n        ")])]),t._v(" "),a("div",{staticClass:"info_2"},[a("p",[t._v("\n          Убийства продолжались, но никто не мог понять, кто за этим стоит. Детектив Л, человек раскрывший самые\n          сложные преступления, вызвался поймать загадочного убийцу. Используя свой ум и чутьё "),a("b",[t._v("Агент")]),t._v(" Л пытается распутать\n          тайны, окутывающие преступника.\n        ")]),t._v(" "),a("img",{attrs:{src:s("u9ek"),alt:"hand"}})]),t._v(" "),a("div",{staticClass:"info_3"},[a("img",{attrs:{src:s("GY21"),alt:"computer"}}),t._v(" "),a("p",[t._v("\n          Многие люди встали на сторону "),a("b",[t._v("Киры")]),t._v(", считая, что преступники действительно заслуживают кары. Другие как "),a("b",[t._v("Агент")]),t._v(" посчитали его\n          обычным убийцей, которого надо поймать и остановить.\n          Выбери сторону и верши своё правосудие.\n        ")])])])])},function(){var t=this.$createElement,e=this._self._c||t;return e("footer",[e("div",{staticClass:"container"},[e("a",{attrs:{href:"#"}},[this._v("Our contacts")])])])}]};var u=s("VU/8")(l,c,!1,function(t){s("aFtA")},null,null).exports,v={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{attrs:{id:"registry"}},[t._m(0),t._v(" "),s("div",{staticClass:"registry"},[s("form",{on:{submit:function(e){return e.preventDefault(),t.signup(e)}}},[s("label",{staticClass:"first_label"},[t._v("\n        Login:\n        "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.login,expression:"login"}],attrs:{type:"text"},domProps:{value:t.login},on:{input:function(e){e.target.composing||(t.login=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),s("label",{staticClass:"second_label"},[t._v("\n        Password:\n        "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{type:"password"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),s("label",{staticClass:"third_label"},[t._v("\n        Retype password:\n        "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.retypePassword,expression:"retypePassword"}],attrs:{type:"password"},domProps:{value:t.retypePassword},on:{input:function(e){e.target.composing||(t.retypePassword=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),s("label",{staticClass:"fourth_label"},[t._v("\n        Email:\n        "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],attrs:{type:"text"},domProps:{value:t.email},on:{input:function(e){e.target.composing||(t.email=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),this.$store.getters.failed?s("p",{staticStyle:{color:"red"}},[t._v("Incorrect credentials")]):1===this.$store.getters.errorStatus?s("p",{staticStyle:{color:"red"}},[t._v("\n        User with the login exists "+t._s(this.$store.getters.errorStatus)+"\n      ")]):2===this.$store.getters.errorStatus?s("p",{staticStyle:{color:"red"}},[t._v("\n        The password does not match with retype password\n      ")]):3===this.$store.getters.errorStatus?s("p",{staticStyle:{color:"red"}},[t._v("\n        Password's length is less than 8\n      ")]):4===this.$store.getters.errorStatus?s("p",{staticStyle:{color:"red"}},[t._v("\n        Password contains non-Latin letters\n      ")]):t._e(),t._v(" "),s("input",{staticClass:"sub",attrs:{type:"submit",value:"Sign up"}})]),t._v(" "),s("div",{staticClass:"link"},[s("router-link",{attrs:{to:"/"}},[t._v("Return to welcome page")])],1),t._v(" "),t._m(1)])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{},[e("h1",[this._v("Registration")]),this._v(" "),e("img",{attrs:{src:s("qxWt"),alt:"dn_logo"}})])},function(){var t=this.$createElement,e=this._self._c||t;return e("footer",[e("div",{staticClass:"container"},[e("a",{attrs:{href:"#"}},[this._v("Our contacts")])])])}]};var p=s("VU/8")({name:"Registry",data:function(){return{login:"",password:"",retypePassword:"",email:""}},methods:{signup:function(){this.$store.dispatch("signup",{login:this.login,password:this.password,retypePassword:this.retypePassword,email:this.email}).then()}}},v,!1,function(t){s("uMli")},"data-v-1784b40a",null).exports,d={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{attrs:{id:"recovery"}},[t._m(0),t._v(" "),s("div",{staticClass:"recovery"},[s("label",{staticClass:"first_label"},[t._v("\n      Email:\n      "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],attrs:{type:"text"},domProps:{value:t.email},on:{input:function(e){e.target.composing||(t.email=e.target.value)}}})]),t._v(" "),s("br"),t._v(" "),s("input",{staticClass:"sub",attrs:{type:"submit",value:"Send password"}}),t._v(" "),s("div",{staticClass:"link"},[s("router-link",{attrs:{to:"/"}},[t._v("Return to welcome page")])],1),t._v(" "),t._m(1)])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"info"},[e("h1",[this._v("Recovery")]),this._v(" "),e("img",{attrs:{src:s("qxWt"),alt:"dn_logo"}})])},function(){var t=this.$createElement,e=this._self._c||t;return e("footer",[e("div",{staticClass:"container"},[e("a",{attrs:{href:"#"}},[this._v("Our contacts")])])])}]};var m=s("VU/8")({name:"Forgot"},d,!1,function(t){s("ctyg")},"data-v-2769e2ab",null).exports,_={render:function(){var t=this.$createElement;return(this._self._c||t)("div",[this._v("\n  Вы вошли!\n")])},staticRenderFns:[]};var g=s("VU/8")({name:"Game"},_,!1,function(t){s("+dZy")},"data-v-00b49c8a",null).exports,f={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("p",[this._v("\n    Вам на почту должно было прийти сообщение. Перейдите по ссылке, чтобы завершить аутентификацию.\n  ")]),this._v(" "),e("router-link",{attrs:{to:"/"}},[this._v("Return to welcome page")])],1)},staticRenderFns:[]};var h=s("VU/8")({name:"Confirm"},f,!1,function(t){s("O01m")},"data-v-3bcafab3",null).exports;a.a.use(i.a);var w=new i.a({mode:"history",hash:!1,routes:[{path:"/",name:"Main",component:u},{path:"/registry",name:"Registry",component:p},{path:"/recovery",name:"Forgot",component:m},{path:"/game",name:"Game",component:g},{path:"/confirm",name:"Confirm",component:h}]}),b={state:{login:[],isFailed:!1},mutations:{setLogin:function(t,e){t.login=e},setFailed:function(t,e){t.isFailed=e}},getters:{isFailed:function(t){return t.isFailed}},actions:{signIn:function(t,e){r()("/login",{params:{username:e.username,password:e.password},method:"POST"}).then(function(e){(e.status=200)?w.push("/game"):t.commit("setFailed",!0)}).catch(function(e){t.commit("setFailed",!0)})}}},y={state:{regData:[],failed:!1,errorStatus:0},mutations:{setLogin:function(t,e){t.login=e},setFailed:function(t,e){t.failed=e},setStatus:function(t,e){t.errorStatus=e}},getters:{failed:function(t){return t.failed},status:function(t){return t.errorStatus}},actions:{signup:function(t,e){var s=this;r.a.post("/signup",{login:e.login,password:e.password,retypePassword:e.retypePassword,email:e.email}).then(function(e){s.errorStatus=e.data,console.log(s.errorStatus),0!==e.data&&(t.commit("setFailed",!0),w.push("/registry")),0==e.data&&w.push("/confirm")}).catch(function(e){t.commit("setFailed",!0)})}}},C=s("NYxO");a.a.use(C.a);var x=new C.a.Store({modules:{login:b,registry:y}}),$={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]},k=s("VU/8")({name:"App"},$,!1,null,null,null).exports;a.a.config.productionTip=!1,new a.a({el:"#app",store:x,router:w,components:{App:k},template:"<App/>"})},O01m:function(t,e){},WJwM:function(t,e,s){t.exports=s.p+"static/img/note.6e353ac.png"},ZWcX:function(t,e){},aFtA:function(t,e){},bTEt:function(t,e,s){t.exports=s.p+"static/img/kira.f3f5038.png"},ctyg:function(t,e){},kubR:function(t,e,s){t.exports=s.p+"static/img/vk_logo.d7a26bb.png"},likQ:function(t,e,s){t.exports=s.p+"static/img/google_logo.5499a33.png"},qxWt:function(t,e,s){t.exports=s.p+"static/img/dn_logo.2d7fe6d.jpg"},u9ek:function(t,e,s){t.exports=s.p+"static/img/hand.4b92932.png"},uMli:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.420920c22bc1fda2e97e.js.map