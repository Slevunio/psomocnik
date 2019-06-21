
Vue.component('edit-button',{
    props:['elementid'],
    template:    `
                    <button type="button" class="btn btn-psomocnik" @click="setElementId(elementid)" data-toggle="modal" data-target="#editModal">
                        Edytuj
                     </button>
                `,
    methods:{
        setElementId(elementid){
            this.$parent.setElementId(elementid);
        }
    }
});

Vue.component('input-text',{
    props:[
        'type',
        'name',
        'label',
        'placeholder',
        'value'
    ],

    data(){
        return{ inputValue:''}
    },
    watch:{
        inputValue(val){
            this.$emit('input', val);
        }
    },
    template:`
        <div class="form-group">
            <label for="name"><h5>{{label}}</h5></label>
            <input :type="type" :id="name" :name="name" :placeholder="placeholder" class="form-control" :value="value" v-model="inputValue">
        </div>
    `

});
Vue.component('input-radio', {
    props:{
        label: String,
        name: String,
        values: Array
    },

    data(){
        return {choosedVal: '',
                class1:'',
                class2:''}
    },

    methods:{
        setActive1(){
            this.class1='active';
            this.class2='';
        },
        setActive2(){
            this.class1='';
            this.class2='active';
        }
    },

    watch:{
        choosedVal(val){
            this.$emit('input', val);
        }
    },

    template: `
        <div>
            <h5>{{label}}</h5>

        <div class="btn-group btn-group-toggle">
            <label v-bind:class="'btn btn-psomocnik '+class1">
                <input type="radio" :name="name+1" :value="values[0]" autocompleted="off" @click="setActive1()" v-model="choosedVal">{{values[0]}}
            </label>
            <label v-bind:class="'btn btn-psomocnik '+class2">
                <input type="radio" :name="name+2" :value="values[1]" autocompleted="off" @click="setActive2()" v-model="choosedVal">{{values[1]}}
            </label>
        </div>
        </div>
    `
})