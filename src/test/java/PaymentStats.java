import java.util.Date;

public class PaymentStats {
    Date date;
    float summ;
    String uid;
    String idPointofSale;

    public PaymentStats(Date date, float summ, String uid, String idPointofSale) {
        this.date = date;
        this.summ = summ;
        this.uid = uid;
        this.idPointofSale = idPointofSale;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIdPointofSale() {
        return idPointofSale;
    }

    public void setIdPointofSale(String idPointofSale) {
        this.idPointofSale = idPointofSale;
    }

    @Override
    public String toString() {
        return "PaymentStats{" +
                "date=" + date +
                ", summ=" + summ +
                ", uid='" + uid + '\'' +
                ", idPointofSale='" + idPointofSale + '\'' +
                '}';
    }
}
