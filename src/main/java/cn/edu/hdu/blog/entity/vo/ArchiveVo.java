package cn.edu.hdu.blog.entity.vo;

public class ArchiveVo {

    private Integer year;
    private Integer month;
    private Long count;

    public ArchiveVo() {
    }


    public ArchiveVo(int year, int month, long count) {
        this.year = year;
        this.month = month;
        this.count = count;
    }

    public ArchiveVo(int year, int month) {
        this.year = year;
        this.month = month;
    }

    @Override
    public String toString() {
        return "ArchiveVo{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", count=" + count +
                '}';
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
