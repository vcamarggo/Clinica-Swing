package enumeration;

import view.View;
import view.GerenciadorDeMensagensView;
import view.MedicoView;
import view.SecretariaView;

/**
 * @author F.Carvalho / M. Hirose / V.Camargo
 */
public enum Usuario {

    /**
     * Retorna a view do usuario medico.
     */
    MEDICO {

        @Override
        public View iniciaView() {
            return new MedicoView();
        }
    },

    /**
     * Retorna a view do usuario secretaria.
     */
    SECRETARIA {

        @Override
        public View iniciaView() {
            return new SecretariaView();
        }
    },

    /**
     * Retorna a view do usuario gerenciador de mensagem.
     */
    GERENCIADORMENSAGEM {

        @Override
        public View iniciaView() {
            return new GerenciadorDeMensagensView();
        }
    };

    /**
     * garan
     * 
     * @return uma classe que implementa view.
     */
    public abstract View iniciaView();

}
