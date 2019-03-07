<template>
    <div>
      <Header></Header>
      <button v-on:click="isActive = !isActive" >text</button>
    </div>
</template>

<script>
    import Header from "@/components/main/Header";
    export default {
        name: "About",
      components: {Header},
      data (){
        return {
          isActive: false
        }
      }
    }
</script>

<style scoped>

</style>
