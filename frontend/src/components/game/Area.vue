<template>
  <div>
    <Header></Header>
    <!--killer's area-->
    <div v-if="this.$store.getters.isKira && !this.$store.getters.matchEnded">
      <!--User's data-->
      <UserData></UserData>
      <!--News-->
      <div>
        <div v-for="news in this.$store.getters.news">
          <p><b>Breaking news!</b></p>
          <p>Дата публикации: {{news.pubDate}}</p>
          <p>Заголовок: {{news.description}}</p>
          <p>Что случилось:
            {{news.victimName}} {{news.victimSurname}} {{news.victimPatr}} {{news.actionDesc}}
          </p>
          <p v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный:
            {{news.guiltyPersonName}}
            {{news.guiltyPersonSername}} {{news.guiltyPersonPatr}}
          </p>
          <p>Место происшествия: {{news.actionPlace}}</p>
        </div>
        <!--Errors-->
        <div v-if="this.$store.getters.entryStatus !== 0">
          <div v-if="this.$store.getters.entryStatus === 1">
            <p>Описнаие не может превышать 50 символов</p>
          </div>
          <div v-if="this.$store.getters.entryStatus === 4">
            <p>Uncorrected death date</p>
          </div>
          <div v-if="this.$store.getters.entryStatus === 10">
            <p>Такая запись уже существует</p>
          </div>
        </div>
      </div>
      <!--Actions-->
      <div>
        <button class="button16" @click="openNote();getActions();getActionPlaces()">Открыть тетрадь</button>
        <br>
        <div v-if="isNoteOpen===true">
          <button class="button16" @click="getEntryPages();getEntries();openEntries()">Посмотреть записи</button>
          <br>
          <div v-if="isEntriesOpen===true">
            <select class="form-control" v-model="numPage">
              <option>Выберите страницу</option>
              <option v-for="number in this.$store.getters.entryPages" v-bind:value="number">{{number}}</option>
            </select>
            <div v-for="entry in this.$store.getters.entry">
              <p>{{entry.victimName}} {{entry.victimSurname}} {{entry.victimPatr}}
              </p>
              <p>Описание смерти: {{entry.desc}}</p>
              <p>Причина смерти: {{entry.deathReason}}</p>
              <p>Место смерти: {{entry.deathPlace}}</p>
              <p>Время смерти: {{entry.deathDataTime}}</p>
            </div>
            <br>
            <button class="button16" @click="closeEntries()">Закрыть записи</button>
          </div>
          <br>
          <button class="button16" @click="openEntryForm()">Открыть форму записи</button>
          <br>
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
            <select v-model="entryForm.victimSex" required>
              <option v-bind:value="true">Мужчина</option>
              <option v-bind:value="false">Женщина</option>
            </select>
            <fieldset class="desc">
              <input class="form-input" type="text" v-model="entryForm.desc" placeholder="Описание смерти" required>
            </fieldset>
            <br>
            <p>Choose Action</p>
            <select class="form-control" v-model="entryForm.actionId" required>
              <option v-for="action in this.$store.getters.action" v-bind:value="action.id">{{action.desc}}</option>
            </select>
            <br>
            <p>Choose ActionPlace</p>
            <select class="form-control" v-model="entryForm.actionPlaceId" required>
              <option v-for="actionPlace in this.$store.getters.actionPlace" v-bind:value="actionPlace.id">{{actionPlace.place}}</option>
            </select>
            <br>
            <label class="fifth_label">
              Дата смерти:
              <datetime v-model="entryForm.deathDate" type="datetime" format="yyyy-MM-dd HH:mm:ss"></datetime>
            </label>
            <div>
              <button type="submit" class="submit" @click="makeEntry();closeEntryForm();clearForm();closeEntries();closeNote()"><a>Сделать запись</a></button>
            </div>
            <br>
            <div>
              <button class="button16" @click="closeEntryForm()">Закрыть форму записи</button>
            </div>
            <br>
          </div>
          <br>
          <button class="button16" @click="closeNote();closeEntryForm()">Закрыть тетрадь</button>
        </div>
      </div>
    </div>

    <!--agent's area-->
    <div v-if="!this.$store.getters.isKira && !this.$store.getters.matchEnded">

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
          <p>Что случилось:
            {{news.victimName}} {{news.victimSurname}} {{news.victimPatr}} {{news.actionDesc}}
          </p>
          <p v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный:
            {{news.guiltyPersonName}}
            {{news.guiltyPersonSername}} {{news.guiltyPersonPatr}}
          </p>
          <p>Место происшествия: {{news.actionPlace}}</p>
        </div>
        <div v-if="this.$store.getters.entryStatus !== 0">
          <div v-if="this.$store.getters.entryStatus === 7">
            <p>Такой запрос уже существует.</p>
          </div>
          <div v-if="this.$store.getters.entryStatus === 8">
            <p>There's no person with the identification data</p>
          </div>
          <div v-if="this.$store.getters.entryStatus === 9">
            <p>Идентификация человека не совпадает с базой данных.</p>
          </div>
        </div>
      </div>
      <!--Actions-->

      <!--Errors-->
      <div>
        <div>
          <button class="button16" @click="openNote()">Открыть планшет</button>
          <br>
          <div v-if="isNoteOpen===true">
            <button class="button16" @click="getRequestPages();getRequests();openEntries()">Посмотреть запросы в полицию</button>
            <br>
            <div v-if="isEntriesOpen===true">
              <select class="form-control" v-model="numPage">
                <option>Выберите страницу</option>
                <option v-for="number in this.$store.getters.entryPages" v-bind:value="number">{{number}}</option>
              </select>
              <div v-for="entry in this.$store.getters.entry">
                <p>{{entry.personName}} {{entry.personSurname}} {{entry.personPatr}}
                  {{entry.personSex ? 'мужчина':'женщина'}}
                </p>
                <p>
                  {{entry.success ? 'пойман':'не пойман'}}
                </p>
              </div>
              <br>
              <button class="button16" @click="closeEntries()">Закрыть запросы в полицию</button>
            </div>
            <br>
            <button class="button16" @click="openEntryForm()">Открыть форму запроса</button>
            <br>
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
              <select v-model="entryForm.victimSex" required>
                <option v-bind:value="true">Мужчина</option>
                <option v-bind:value="false">Женщина</option>
              </select>

              <div>
                <button type="submit" class="submit" @click="makeRequest();closeEntryForm();clearForm();closeEntries();closeNote()"><a>Сделать запись</a></button>
              </div>
              <br>
              <div>
                <button class="button16" @click="closeEntryForm()">Закрыть форму запроса</button>
              </div>
              <br>
            </div>
            <button class="button16" @click="openFakeNews();getActions();getActionPlaces()">Создать фальшивую новость</button>
            <!--Fake news:start-->
            <div v-if="isFakeNewsOpen===true">
              <fieldset class="desc">
                <input class="form-input" type="text" v-model="entryForm.desc" placeholder="Описание новости" required>
              </fieldset>
              <br>
              <label class="pubDateLabel">
                Дата публикации:
                <datetime v-model="entryForm.deathDate" type="datetime" format="yyyy-MM-dd HH:mm:ss"></datetime>
              </label>
              <br>
              <p>Choose Action</p>
              <select class="form-control" v-model="entryForm.actionId" required>
                <option v-for="action in this.$store.getters.action" v-bind:value="action.id">{{action.desc}}</option>
              </select>
              <br>
              <p>Choose ActionPlace</p>
              <select class="form-control" v-model="entryForm.actionPlaceId" required>
                <option v-for="actionPlace in this.$store.getters.actionPlace" v-bind:value="actionPlace.id">{{actionPlace.place}}</option>
              </select>
              <br>
              <p>
                Выберете регион, где всё произошло.
              </p>
              <div class="common_region">
                <div id="center-select-1">
                  <div class="select-custom">
                    <select class="region-selector" v-model="commonRegion.continent">
                      <option value="null" disabled>Континент</option>
                      <option v-for="continent in this.$store.getters.continents" v-bind:value="continent">{{continent}}</option>
                    </select>
                  </div>

                  <div class="select-custom">
                    <select class="region-selector" v-model="commonRegion.country" v-if="commonRegion.continent!=null">
                      <option value="null" disabled>Страна</option>
                      <option v-for="country in this.$store.getters.countries" v-bind:value="country">{{country}}</option>
                    </select>
                  </div>

                  <div class="select-custom">
                    <select class="region-selector" v-model="commonRegion.city" v-if="commonRegion.country!=null">
                      <option value="null" disabled>Город</option>
                      <option v-for="city in this.$store.getters.cities" v-bind:value="city">{{city}}</option>
                    </select>
                  </div>
                </div>
              </div>
              <p>
                Выберете регион, на который будут распространяться новости.
              </p>
              <div class="dist_region">
                <div id="center-select-2">
                  <div class="select-custom">
                    <select class="region-selector" v-model="distRegion.continent">
                      <option value="null" disabled>Континент</option>
                      <option v-for="continent in this.$store.getters.distContinents" v-bind:value="continent">{{continent}}</option>
                    </select>
                  </div>

                  <div class="select-custom">
                    <select class="region-selector" v-model="distRegion.country" v-if="distRegion.continent!=null">
                      <option value="null" disabled>Страна</option>
                      <option v-bind:value="0">Нет</option>
                      <option v-for="country in this.$store.getters.distCountries" v-bind:value="country">{{country}}</option>
                    </select>
                  </div>

                  <div class="select-custom">
                    <select class="region-selector" v-model="distRegion.city" v-if="distRegion.country!=null">
                      <option value="null" disabled>Город</option>
                      <option v-bind:value="0">Нет</option>
                      <option v-for="city in this.$store.getters.distCities" v-bind:value="city">{{city}}</option>
                    </select>
                  </div>
                </div>
              </div>


              <button class="button16" @click="closeFakeNews();clearNews()">Закрыть раздел создания новостей</button>
            </div>
            <!--Fake news:end-->
            <br>
            <button class="button16" @click="closeNote();closeEntryForm()">Закрыть планшет</button>
          </div>
        </div>
      </div>
    </div>

    <div v-if="this.$store.getters.matchEnded">
      <div v-if="this.$store.getters.isKira">
        <div v-if="this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы победили.
        </div>
        <div v-if="!this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы проиграли.
        </div>
        <div v-if="this.$store.getters.isGameDrawn">
          Ничья.
        </div>
      </div>
      <div v-if="!this.$store.getters.isKira">
        <div v-if="!this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы победили.
        </div>
        <div v-if="this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы проиграли.
        </div>
        <div v-if="this.$store.getters.isGameDrawn">
          Ничья.
        </div>
      </div>
      <button class="button16" @click="exit()">Вернутся в меню выбора</button>
    </div>
  </div>
</template>

<script>
  import router from '../../router'
  import Header from "@/components/main/Header";
  import UserData from "@/components/game/UserData";
  export default {
    name: "Area",
    components: {UserData, Header},
    data() {
      return {
        isNoteOpen: false,
        isEntriesOpen: false,
        isEntryFormOpen: false,
        isFakeNewsOpen: false,
        distRegionStatus: true,
        numPage: 1,
        entryForm: {
          desc: '',
          deathDate: null,
          actionId: null,
          actionPlaceId: null,

          victimName: '',
          victimSurname: '',
          victimPatr: '',
          victimSex: undefined
        },
        newsForm: {
          distRegionId: null,
          victimId: null,
          guiltyPersonId: null
        },
        commonRegion: {
          regionId: null,
          country: null,
          continent: null,
          city: null
        },
        distRegion: {
          regionId: null,
          country: null,
          continent: null,
          city: null
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
        }
        else {
          this.$store.dispatch('getAgentNews')
        }
      },
      getStatus(){
        console.log(this.$store.getters.isKira)
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
      openEntries(){
        this.isEntriesOpen = true
      },
      closeEntries(){
        this.isEntriesOpen = false
      },
      openFakeNews(){
        this.isFakeNewsOpen = true
      },
      closeFakeNews(){
        this.isFakeNewsOpen = false
      },
      getEntryPages() {
        this.$store.dispatch('getEntryPages')
      },
      getEntries() {
        this.$store.dispatch('getEntries')
      },
      getRequests() {
        this.$store.dispatch('getRequests')
      },
      getRequestPages() {
        this.$store.dispatch('getRequestPages')
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

      makeRequest() {
        this.$store.dispatch('makeRequest',
          {
            victimName: this.entryForm.victimName,
            victimSurname: this.entryForm.victimSurname,
            victimPatr: this.entryForm.victimPatr,
            victimSex: this.entryForm.victimSex,
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
      },
      clearForm(){
        this.entryForm.actionId = null
        this.entryForm.victimName = ''
        this.entryForm.victimSurname = ''
        this.entryForm.victimPatr = ''
        this.entryForm.victimSex = undefined
        this.entryForm.desc = ''
        this.entryForm.deathDate = null
        this.entryForm.actionPlaceId = null
      },
      kiraWin(){
        this.$store.dispatch('kiraWin')
      },
      agentWin(){
        this.$store.dispatch('agentWin')
      },
      exit(){
        router.push("/game")
      },

      getPersons(){
        this.$store.dispatch('getPersons',
          {
            usedPersonId: this.newsForm.guiltyPersonId
          }
        )
      },
      createFakeNews(){
        this.$store.dispatch('createFakeNews',
          {
            desc: this.entryForm.desc,
            pubDate: this.entryForm.deathDate,
            actionId: this.entryForm.actionId,
            actionPlaceId: this.entryForm.actionPlaceId,
            commonRegionId: this.$store.getters.id,
            distRegionId: this.$store.getters.distId,
            victimId: this.newsForm.victimId,
            guiltyPersonId: this.newsForm.guiltyPersonId
          }
        )
      },
      getCommonRegionsWithContinents(){
        this.$store.dispatch('getRegionsWithContinents').then()
      },
      getCommonRegionsWithCountries(){
        this.$store.dispatch('getRegionsWithCountries', {continent: this.commonRegion.continent}).then()
      },
      getCommonRegionsWithCities(){
        this.$store.dispatch('getRegionsWithCities', {country: this.commonRegion.country}).then()
      },
      getCommonRegionId(){
        this.$store.dispatch('getRegionId', {city: this.commonRegion.city}).then()
      },

      getDistRegionsWithContinents(){
        this.$store.dispatch('getDistContinents').then()
      },
      getDistRegionsWithCountries(){
        this.$store.dispatch('getDistRegionsWithCountries', {continent: this.distRegion.continent}).then()
      },
      getDistRegionsWithCities(){
        this.$store.dispatch('getDistRegionsWithCities', {country: this.distRegion.country}).then()
      },
      getFullRegionId(){
        this.$store.dispatch('getFullRegionId',
          {
            city: this.distRegion.city,
            country: this.distRegion.country,
            continent: this.distRegion.continent
          }
        )
      },
      clearNews(){
        this.entryForm.desc = ''
        this.entryForm.pubDate = null
        this.entryForm.actionId = null
        this.entryForm.actionPlaceId = null
        this.newsForm.commonRegionId = null
        this.newsForm.distRegionId = null
        this.newsForm.victimId = null
        this.newsForm.guiltyPersonId = null
      }
    },
    mounted() {
      this.getStatus()
      this.getNews()
      this.getCommonRegionsWithContinents();
      this.getDistRegionsWithContinents();
    },
    watch: {
      numPage: function (val) {
        this.$store.commit('setNumPage', val)
        if (this.$store.getters.isKira())
          this.getEntries()
        else
          this.getRequests()
      },
      'commonRegion.continent': function (val) {
        this.commonRegion.country = null
        this.commonRegion.city = null
        this.getCommonRegionsWithCountries()
      },
      'commonRegion.country': function (val) {
        this.commonRegion.city = null
        this.getCommonRegionsWithCities()

      },
      'commonRegion.city': function (val) {
        console.log('')
        this.getCommonRegionId()
      },
      'distRegion.continent': function (val) {
        this.distRegion.country = 0
        this.distRegion.city = 0
        this.getDistRegionsWithCountries()
      },
      'distRegion.country': function (val) {
        this.distRegion.city = 0
        this.getDistRegionsWithCities()
      },
      'distRegion.city': function (val) {
        console.log('')
        this.getFullRegionId()
      }
    }
  }
</script>

<style scoped>

</style>
