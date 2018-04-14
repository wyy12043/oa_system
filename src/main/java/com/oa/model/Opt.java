package com.oa.model;

/**
 * @author wyy
 * @date 2018/4/9
 */
public class Opt {
    private int id ;
    private String text ;
    private String action ;
    private boolean checked = false;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Opt{" +
                "id=" + id +
                ", name='" + text + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
