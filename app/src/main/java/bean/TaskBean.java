package bean;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 13:58
 * 功能：
 */
public class TaskBean {
    private String name;
    private int icon;

    public TaskBean(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
