<template>
  <div>
    <Header></Header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <div class="wrapper">
      <ul>
        <li><i class="fa fa-vk" aria-hidden="true"></i></li>
        <li><i class="fa fa-google-plus" aria-hidden="true"></i></li>
      </ul>
    </div>
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
  .wrapper{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
  }

  ul{
    list-style: none;
    width: 250px;
    height: 100px;
    /*border: 3px blue solid;*/
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

  @media screen and (max-width: 640px){
    .wrapper ul{
      width: 100px;
    }
    .wrapper ul li{
      margin-top: 20px;
    }
  }
</style>
