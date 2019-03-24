<template>
    <div>
      <p>Изменить пароль</p>
      <fieldset class="newPass">
        <input class="form-input" type="password" v-model="newPass" placeholder="Новый пароль" required>
      </fieldset>
    </div>
</template>

<script>
  export default {
    name: "Settings",
    data() {
      return {
        newPass: ''
      }
    },
    methods: {
      changePass(){
        this.$store.dispatch('changePass', {
          newPass: this.newPass
        })
      }
    }
  }
</script>

<style scoped>

</style>
