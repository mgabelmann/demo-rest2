import { createApp } from 'vue'
import App from './App.vue'

//imports
import PrimeVue from 'primevue/config'
import Button from 'primevue/button'

import 'primevue/resources/themes/saga-blue/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'


const app = createApp(App)

app.use(PrimeVue);

//components
app.component('Button', Button)

app.mount('#app');