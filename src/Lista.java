public class Lista<T> implements ILista {

    private T[] elemento;
    private int ultimo;

    public Lista(){
        elemento = (T[]) new Object[5];
        ultimo = 0;
    }

    @Override
    public void add(Object o) throws ListaCheiaException {
        if (this.count() < 5) {
            elemento[ultimo] = (T) o;
            ultimo++;
        } else
            throw new ListaCheiaException("A Lista está cheia!");
    }

    @Override
    public void add(Object o, int index) throws ListaCheiaException {
        if (this.count() < 5) {
            Object auxi;
            auxi = elemento[index];
            elemento[index] = (T) o;
            elemento[ultimo] = (T)auxi;
            ultimo++;

        } else
            throw new ListaCheiaException("A Lista está cheia!");
    }

    @Override
    public void remove(Object o) throws ListaVaziaException, ItemNaoEncontradoException {
        if(ultimo == 0)
            throw new ListaVaziaException("A Lista está vazia!");

        int cont = 0;
        Object auxi;
        for(int i = 0; i < this.ultimo; i++){
            if (o.equals(elemento[i])) {
                auxi = elemento[i];
                elemento[i] = null;
                elemento[ultimo] = (T) auxi;
                break;
            }
            cont++;
        }
        if(cont==this.ultimo)
            throw new ItemNaoEncontradoException("O Item solicitado não foi encontrado na lista!");
    }

    @Override
    public void remove(int i) throws ListaVaziaException, ItemNaoEncontradoException {
        if (this.ultimo > 0) {
            if(elemento[i] != null) {
                elemento[i] = null;
            } else
                throw new ItemNaoEncontradoException("O Item solicitado não foi encontrado na lista!");
        } else
            throw new ListaVaziaException("A Lista está vazia!");
    }

    @Override
    public int find(Object o) throws ItemNaoEncontradoException {
        int cont = 0;

        for(int i = 0; i < ultimo; i++){
            if (elemento[i].equals(o))
                cont++;
        }
        if (cont==0)
            throw new ItemNaoEncontradoException("O Item solicitado não foi encontrado na lista!");

        return cont;
    }

    @Override
    public Object get(int i) throws IndiceForaDosLimitesException {
        Object obj = null;
        if (i <= ultimo)
            obj = elemento[i];
        else
            throw new IndiceForaDosLimitesException("Indice fora dos limites da Lista!");

        return obj;
    }

    @Override
    public int count() {
        return this.ultimo;
    }


}
