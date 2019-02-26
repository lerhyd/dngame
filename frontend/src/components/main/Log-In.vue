<template>
  <div id="app">
    <Header></Header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <section class="left-section">
      <img src="../../assets/img/a1.png"/>
    </section>
    <section class="main-section">

    <div class="wrapper">
      <!--<div id="title">Вход в Аккаунт</div>-->
      <div><img src="../../assets/img/ryuk.png" style="width: 30%"/></div>
      <div style="display: inherit; padding-bottom: 5%">
        <ul>
          <li><i class="fa fa-vk" aria-hidden="true"></i></li>
          <li><i class="fa fa-google-plus" aria-hidden="true"></i></li>
        </ul>
        <fieldset class="login">
          <input class="form-input" type="text" placeholder="Логин" required>
        </fieldset>
        <fieldset class="password">
          <input class="form-input" type="text" placeholder="Пароль" required>
        </fieldset>
        <router-link id="forgot" to="/recovery">Забыли пароль?</router-link>
        <ul>
          <li class="sign-in"><i class="fa fa-sign-in" aria-hidden="true"></i></li>
          <li class="sign-in"><i class="fa fa-user-plus" aria-hidden="true"></i></li>
        </ul>
      </div>
    </div>
    </section>
    <section class="right-section">
      <img src="../../assets/img/a2.png"/>
    </section>
  </div>
</template>

<script>
    import Header from "@/components/main/Header";
    export default {
        name: "Log-In",
      components: {Header}
    }
</script>

<style scoped>

  #forgot{
    font-family: 'Hand';
    color: white;
  }
  fieldset {
    border: none;
    position: relative;
    height: 50px;
    alignment: center;
  }

  fieldset::after {
    font-family: FontAwesome;
    position: absolute;
    right: 45px;
    top: 29px;
    text-align: center;
    color: #880807;
  }

  fieldset.login::after {content: '\f007';}

  fieldset.password::after {content: '\f023';}

  ::placeholder {color: white;}

  .form-input{
    font-family: 'Hand';
    color: white;
    width: 200px;
    height: 40px;
    border-radius: 10px;
    border: 1px solid white;
    user-focus: none;
    background: none;
    outline: none;
    margin-top: 10px;
    font-size: 25px;
    transition: all 0.5s linear;
  }

  .form-input:hover{
    background: rgb(222, 222, 222);
    box-shadow: 0 0 700px 1px #c0c0c0;
    border: 1px solid #474A59;
    color: #882a2e;
  }

  .form-input:hover::placeholder{
    color: #882a2e;
  }

  .form-input::selection{
    color: white;
    background: #474A59;
  }

  .form-input:focus::placeholder{
    color: transparent;
  }

  .wrapper{
    display: inline-block;
    position: center;
    height: 90%;
    width: 60%;
    border: 5px solid rgb(254, 254, 254);
    border-radius: 30px;
  }

  #app{
    text-align: center;
  }

  ul{
    list-style: none;
    width: 240px;
    height: 41px;
    /*border: 1px wheat solid;*/
  }

  ul li{
    float: left;
    width: 80px;
    height: 40px;
    border: 2px solid #fff;
    margin-right: 30px;
    border-radius: 5px;
    position: relative;
    cursor: pointer;
    transition: all 0.3s linear;
  }

  ul li .fa{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    color: #fff;
    font-size: 30px;
    transition: all 0.3s linear;
  }

  ul .sign-in{
    float: left;
    width: 90px;
    height: 40px;
    border: 2px solid #fff;
    margin-right: 10px;
    border-radius: 5px;
    position: relative;
    cursor: pointer;
    transition: all 0.3s linear;
  }


  ul li:hover{
    background: #fff;
    box-shadow: 0 0 300px 1px #c0c0c0;
  }

  ul li:hover .fa-google-plus{
    color: #f06060;
  }

  ul li:hover .fa-vk{
    color: #4A76A8;
  }

  ul li:hover .fa-sign-in{
    color: #111111;}

  ul li:hover .fa-user-plus{
    color: #111111;
  }

  section{
    display: inline-block;
    /*border: 1px darkgrey solid;*/
    width: 25%;
    text-align: center;
  }

  section img{
    width: 100%;
  }
  .left-section{
    float: left;
  }

  .right-section{
    float: right;
  }

  .main-section{
    width: 45%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

  section article {margin: 0 auto;}

  @media screen and (max-width: 700px){
    .wrapper ul{
      width: 100px;
    }
    .wrapper ul li{
      margin-top: 20px;
    }

    section img{
      display: none;
      width: 1px;
    }
  }

  @media screen and (min-width:701px) and (max-width: 1209px){

  }
</style>
