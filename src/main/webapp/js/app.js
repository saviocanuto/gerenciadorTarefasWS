/*
 * INSTANCIA UMA APLICACAO
 */
App = Ember.Application.create({});


/*
 * ARQUIVO JSON PARA TESTE
 */
var tarefas = [{
  id: '1',
  nome: "Pesquisar Tecnologia",
  responsavel: "Joao da Silva",
  date: new Date('08-13-2015')
}, {
  id: '2',
  nome: "Implementar Funcionalidade",
  responsavel: "Marcos Nunes",
  date: new Date('08-13-2015')
}];

/* 
 * ROTEADOR 
 */
App.Router.map(function() {
  this.resource('about');
  this.resource('tarefas', function() {
    this.resource('post', { path: ':post_id' });
  });
});

/* 
 * ROTAS 
 */
App.TarefasRoute = Ember.Route.extend({
/*
  model: function() {
    return tarefas;
  }
*/
  model: function() {
    Ember.$.getJSON('/tarefas', function(tarefas){
      console.log(tarefas);
    });
    return [];
  }
});

App.PostRoute = Ember.Route.extend({
  model: function(params) {
    return tarefas.findBy('id', params.post_id);
  }
});

/*
 * CONTROLLER
 */
App.PostController = Ember.ObjectController.extend({
  isEditing: false,
  
  actions: {
    edit: function() {
      this.set('isEditing', true);
    },

    doneEditing: function() {
      this.set('isEditing', false);
    }
/*
    delete: function(params) {
      tarefas.delete('id', params.post_id);
    } */
  }
});


/*
 * FORMATADORES
 */
var showdown = new Showdown.converter();

Ember.Handlebars.helper('format-markdown', function(input) {
  return new Handlebars.SafeString(showdown.makeHtml(input));
});

Ember.Handlebars.helper('format-date', function(date) {
  return moment(date).fromNow();
});
