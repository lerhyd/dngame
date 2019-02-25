<template>
  <div>
    {{checkIfConfirmed()}}
    <p>Вы вошли!</p>
    <div v-if="!this.$store.getters.loginStatus">
      <p>
        Ваша почта ещё не подтверждена.
      </p>
      <form @submit.prevent="send">
        <input class="sub" type="submit" value="Отправить снова"/>
      </form>
    </div>
    <a href="/logout">Logout</a>
  </div>
</template>

<script>
    export default {
      name: "Game",
      methods: {
        send () {
          this.$store.dispatch('sendToken').then();
        },

        checkIfConfirmed() {
          this.$store.dispatch('checkIfConfirmed').then();
        }
      }
    }
</script>

<style scoped>

</style>
