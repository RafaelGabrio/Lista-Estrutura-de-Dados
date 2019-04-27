public interface ILista {

    void add(Object o) throws ListaCheiaException;
    void add(Object o, int index) throws ListaCheiaException;
    void remove(Object o) throws ListaVaziaException, ItemNaoEncontradoException;
    void remove(int i) throws ListaVaziaException, ItemNaoEncontradoException;
    int find(Object o) throws ItemNaoEncontradoException;
    Object get(int i) throws IndiceForaDosLimitesException;
    int count();
}
