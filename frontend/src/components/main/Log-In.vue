<template>
  <div id="app">
    <Header></Header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <section class="left-section">
      <img src="../../assets/img/apples.png"/>
    </section>
    <section class="main-section">
    <div class="wrapper">
        <ul>
          <li><i class="fa" aria-hidden="true"></i></li>
          <li><i class="fa fa-vk" aria-hidden="true"></i></li>
          <li><i class="fa fa-google-plus" aria-hidden="true"></i></li>
        </ul>
    </div>
    </section>
    <section class="right-section">
      <img src="../../assets/img/r.png"/>
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

  #app{
    text-align: center;
    alignment: center;
    align-content: center;
    align-items: center;
  }
  .wrapper{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
  }

  ul{
    list-style: none;
    width: 300px;
    height: 100px;
    border: 3px blue solid;
  }

  ul li{
    float: left;
    width: 55px;
    height: 50px;
    border: 2px solid #fff;
    margin-right: 36px;
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

  section{
    padding-top: 5%;
    padding-bottom: 4%;
    display: inline-block;
    /*border: 2px red solid;*/
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
  }

  @media screen and (max-width: 640px){
    .wrapper ul{
      width: 100px;
    }
    .wrapper ul li{
      margin-top: 20px;
    }

    section img{
      display: none;
      width: 1%;
    }
  }
</style>
