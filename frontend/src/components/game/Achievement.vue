<template>
  <div>
    <div class="achievement-option">
      {{title}}
    </div>
  </div>
</template>

<script>
  export default {
    name: "Achievement",
    props: ['title'],
  }
</script>

<style scoped>

  .achievement-option{
    display: inline-block;
    position: center;
    height: 70px;
    margin-top: 20px;
    /*margin-bottom: 15px;*/
    width: 60%;
    border: green 2px solid;
    border-radius: 20px;
    font-family: 'Hand';
    font-size: x-large;
    color: white;
  }

</style>
