<template>
    <div>
      <p>Изменить пароль</p>
      <fieldset class="oldPass">
        <input class="form-input" type="password" v-model="oldPass" placeholder="Старый пароль" required>
      </fieldset>
      <fieldset class="newPass">
        <input class="form-input" type="password" v-model="newPass" placeholder="Новый пароль" required>
      </fieldset>
      <fieldset class="retypeNewPass">
        <input class="form-input" type="password" v-model="retypeNewPass" placeholder="Снова введите новый пароль" required>
      </fieldset>

      <div class="errors" v-if="this.$store.getters.passwordStatus !== 0">
        <div v-if="this.$store.getters.passwordStatus === 2">
          <p>
            Password's length is less than 6.
          </p>
        </div>
        <div v-if="this.$store.getters.passwordStatus === 3">
          <p>
            Password contains non-Latin letters.
          </p>
        </div>
        <div v-if="this.$store.getters.passwordStatus === 4">
          <p>
            Password does not match with retype password.
          </p>
        </div>
        <div v-if="this.$store.getters.passwordStatus === 5">
          <p>
            Old pass is incorrect.
          </p>
        </div>
      </div>
    </div>
</template>

<script>
  export default {
    name: "Settings",
    data() {
      return {
        oldPass: '',
        newPass: '',
        retypeNewPass: ''
      }
    },
    methods: {
      changePass(){
        this.$store.dispatch('changePass', {
          oldPass: this.oldPass,
          newPass: this.newPass,
          retypeNewPass: this.retypeNewPass
        })
      }
    }
  }
</script>

<style scoped>

</style>
