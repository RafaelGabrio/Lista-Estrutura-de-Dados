public class ItemNaoEncontradoException extends Exception{
    private String msg;

    public ItemNaoEncontradoException(String msg){
        super(msg);
        this.msg = msg;
    }
}
