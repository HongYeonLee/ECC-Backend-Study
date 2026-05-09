package hongyeon_spring.domain;

public class Member {

    private Long id; //고객이 정하는게 아니라 시스템이 정하는 고객아이디
    private String name; //고객이 회원가입할 때 적는 내용

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
