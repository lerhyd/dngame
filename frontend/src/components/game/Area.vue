<template>
    <div>
      <!--killer's area-->
      <div v-if="this.$store.getters.isKira">
        <!--User's data-->
        <div>
          <div v-for="user in this.$store.getters.user">
            <p>{{user.login}}</p>
          </div>
          <div v-for="status in this.$store.getters.status">
            <p>points: {{status.points}}</p>
            <p>lvl: {{status.lvl}}</p>
            <p>rank: {{status.rank}}</p>
            <p>number of right kills: {{status.numberOfRightKills}}</p>
          </div>
        </div>
        <!--News-->
        <div>
          <div v-for="news in this.$store.getters.news">
            <p><b>Breaking news!</b></p>
            <p>Дата публикации: {{news.pubDate}}</p>
            <p>Заголовок: {{news.description}}</p>
            <p>Что случилось: {{news.victimSex ? 'мужчина' : 'женщина'}}
              {{news.victimName}} {{news.victimSurname}} {{news.victimPatr}} {{news.actionDesc}}
            </p>
            <p v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный:
              {{news.guiltyPersonSex ? 'мужчина' : 'женщина'}} {{news.guiltyPersonName}}
              {{news.guiltyPersonSername}} {{news.guiltyPersonPatr}}
            </p>
            <p>Место происшествия: {{news.actionPlace}}</p>
          </div>
        </div>
        <!--Actions-->
        <div>
          <button class="button16" @click="openNote();getEntryPages();getEntries();getActions();getActionPlaces()">Открыть тетрадь</button>
          <div v-if="isNoteOpen===true">
            <select class="form-control" v-model="pageNum">
              <option>Выберите страницу</option>
              <option v-for="number in this.$store.getters.entryPages" v-bind:value="this.NumPage" @click="this.$store.commit('setNumPage', this.NumPage)">{{number}}</option>
            </select>
            <div v-for="entry in this.$store.getters.entry">
              <p>{{entry.victimName}} {{entry.victimSurname}} {{entry.victimPatr}}
                 {{entry.victimSex ? 'мужчина':'женщина'}}
              </p>
              <p>Описание смерти: {{entry.desc}}</p>
              <p>Причина смерти: {{entry.deathReason}}</p>
              <p>Место смерти: {{entry.deathPlace}}</p>
              <p>Время смерти: {{entry.deathDataTime}}</p>
            </div>
            <br>
            <button class="button16" @click="openEntryForm()">Открыть форму записи</button>
            <div v-if="isEntryFormOpen===true">
              <fieldset class="victimName">
                <input class="form-input" type="text" v-model="entryForm.victimName" placeholder="Имя человека" required>
              </fieldset>
              <fieldset class="victimSurname">
                <input class="form-input" type="text" v-model="entryForm.victimSurname" placeholder="Фамилия человека" required>
              </fieldset>
              <fieldset class="victimPatr">
                <input class="form-input" type="text" v-model="entryForm.victimPatr" placeholder="Отчество человека" required>
              </fieldset>
              <select v-model="entryForm.victimSex">
                <option disabled value="">Пол человека</option>
                <option v-bind:value="true">Мужчина</option>
                <option v-bind:value="false">Женщина</option>
              </select>
              <fieldset class="desc">
                <input class="form-input" type="text" v-model="entryForm.desc" placeholder="Описание смерти" required>
              </fieldset>
              <br>
              <p>Choose Action</p>
              <select class="form-control" v-model="entryForm.actionId">
                <option v-for="action in this.$store.getters.action" v-bind:value="action.id">{{action.desc}}</option>
              </select>
              <br>
              <p>Choose ActionPlace</p>
              <select class="form-control" v-model="entryForm.actionPlaceId">
                <option v-for="actionPlace in this.$store.getters.actionPlace" v-bind:value="actionPlace.id">{{actionPlace.place}}</option>
              </select>
              <br>
              <label class="fifth_label">
                Дата смерти:
                <datetime v-model="entryForm.deathDate" type="datetime" format="yyyy-MM-dd HH:mm:ss"></datetime>
              </label>
              <p id="fail-message">
                <a v-if="this.$store.getters.entryStatus == 4">Death date is before then current date</a>
                <a v-else-if="this.$store.getters.entryStatus == 8">Kira committed suicide</a>
                <a v-else-if="this.$store.getters.entryStatus == 9">The victim with the ID has already died</a>
                <a v-else-if="this.$store.getters.entryStatus == 10">The entry with the victim already exists</a>
                <a v-else-if="this.$store.getters.entryStatus == 12">The Kira' location was finally declassified</a>
              </p>
              <div>
                <button type="submit" class="submit" @click="makeEntry();closeEntryForm()"><a>Сделать запись</a></button>
              </div>
              <div>
                <button class="button16" @click="closeEntryForm()">Закрыть форму записи</button>
              </div>
            </div>
            <br>
            <button class="button16" @click="closeNote();closeEntryForm()">Закрыть тетрадь</button>
          </div>
        </div>
      </div>

      <!--agent's area-->
      <div v-if="!this.$store.getters.isKira">

        <!--User's data-->
        <div>
          <div v-for="user in this.$store.getters.user">
            <p>{{user.login}}</p>
          </div>
          <div v-for="status in this.$store.getters.status">
            <p>points: {{status.points}}</p>
            <p>lvl: {{status.lvl}}</p>
            <p>rank: {{status.rank}}</p>
            <p>number Of Caught Killers: {{status.numberOfCaughtKillers}}</p>
          </div>
        </div>
        <!--News-->
        <div>
          <div v-for="news in this.$store.getters.news">
            <p><b>Breaking news!</b></p>
            <p>Дата публикации: {{news.pubDate}}</p>
            <p>Заголовок: {{news.description}}</p>
            <p>Что случилось: {{news.victimSex ? 'мужчина' : 'женщина'}}
              {{news.victimName}} {{news.victimSurname}} {{news.victimPatr}} {{news.actionDesc}}
            </p>
            <p v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный:
              {{news.guiltyPersonSex ? 'мужчина' : 'женщина'}} {{news.guiltyPersonName}}
              {{news.guiltyPersonSername}} {{news.guiltyPersonPatr}}
            </p>
            <p>Место происшествия: {{news.actionPlace}}</p>
          </div>
        </div>
        <!--Actions-->
        <div>

        </div>
      </div>
    </div>
</template>

<script>
  export default {
    name: "Area",
    data() {
      return {
        isNoteOpen: false,
        isEntryFormOpen: false,
        NumPage: null,
        entryForm: {
          actionId: null,
          victimName: '',
          victimSurname: '',
          victimPatr: '',
          victimSex: undefined,
          desc: '',
          deathDate: null,
          actionPlaceId: null
        }
      }
    },
    methods: {
      getKiraStatus(){
        this.$store.dispatch('getKiraStatus')
      },
      getAgentStatus(){
        this.$store.dispatch('getAgentStatus')
      },
      getKiraNews(){
        this.$store.dispatch('getKiraNews')
      },
      getAgentNews(){
        this.$store.dispatch('getAgentNews')
      },
      getNews(){
        if (this.$store.getters.isKira) {
          this.$store.dispatch('getKiraNews')
          console.log('getKiraNews')
        }
        else {
          this.$store.dispatch('getAgentNews')
          console.log('getAgentNews')
        }
      },
      getStatus(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraStatus')
        else
          this.$store.dispatch('getAgentStatus')
      },
      openNote(){
        this.isNoteOpen = true
      },
      closeNote(){
        this.isNoteOpen = false
      },
      openEntryForm(){
        this.isEntryFormOpen = true
      },
      closeEntryForm(){
        this.isEntryFormOpen = false
      },
      getEntryPages() {
        this.$store.dispatch('getEntryPages')
      },
      getEntries() {
        this.$store.dispatch('getEntries')
      },
      makeEntry() {
        this.$store.dispatch('makeEntry',
          {
            actionId: this.entryForm.actionId,
            victimName: this.entryForm.victimName,
            victimSurname: this.entryForm.victimSurname,
            victimPatr: this.entryForm.victimPatr,
            victimSex: this.entryForm.victimSex,
            desc: this.entryForm.desc,
            deathDate: this.entryForm.deathDate,
            actionPlaceId: this.entryForm.actionPlaceId
          }
        )
      },
      getActions(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraActions')
        else
          this.$store.dispatch('getAgentActions')
      },
      getActionPlaces(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraActionPlaces')
        else
          this.$store.dispatch('getAgentActionPlaces')
      }

    },
    mounted() {
      this.getStatus()
      this.getNews()
    }
  }
</script>

<style scoped>

</style>
