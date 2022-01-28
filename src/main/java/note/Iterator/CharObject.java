package note.Iterator;

/**
* @Author: WYF
* @Description:
* @Create: 2020/6/7 18:45
* @Version: 1.0
*/
public class CharObject implements HaveIterator{
    Character[] charLisr;

    @Override
    public Iterator CreateIterator() {
        return new MyIterator(charLisr);
    }

    public void setCharLisr(Character[] charLisr) {
        this.charLisr = charLisr;
    }
}
