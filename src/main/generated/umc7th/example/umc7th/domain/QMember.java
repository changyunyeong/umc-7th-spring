package umc7th.example.umc7th.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -388245784L;

    public static final QMember member = new QMember("member1");

    public final umc7th.example.umc7th.domain.common.QBaseEntity _super = new umc7th.example.umc7th.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc7th.example.umc7th.domain.enums.Gender> gender = createEnum("gender", umc7th.example.umc7th.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc7th.example.umc7th.domain.mapping.MemberAgree, umc7th.example.umc7th.domain.mapping.QMemberAgree> memberAgreeList = this.<umc7th.example.umc7th.domain.mapping.MemberAgree, umc7th.example.umc7th.domain.mapping.QMemberAgree>createList("memberAgreeList", umc7th.example.umc7th.domain.mapping.MemberAgree.class, umc7th.example.umc7th.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc7th.example.umc7th.domain.mapping.MemberMission, umc7th.example.umc7th.domain.mapping.QMemberMission> memberMissionList = this.<umc7th.example.umc7th.domain.mapping.MemberMission, umc7th.example.umc7th.domain.mapping.QMemberMission>createList("memberMissionList", umc7th.example.umc7th.domain.mapping.MemberMission.class, umc7th.example.umc7th.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc7th.example.umc7th.domain.mapping.MemberPrefer, umc7th.example.umc7th.domain.mapping.QMemberPrefer> memberPreferList = this.<umc7th.example.umc7th.domain.mapping.MemberPrefer, umc7th.example.umc7th.domain.mapping.QMemberPrefer>createList("memberPreferList", umc7th.example.umc7th.domain.mapping.MemberPrefer.class, umc7th.example.umc7th.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> Point = createNumber("Point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc7th.example.umc7th.domain.enums.SocialType> socialType = createEnum("socialType", umc7th.example.umc7th.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc7th.example.umc7th.domain.enums.MemberStatus> status = createEnum("status", umc7th.example.umc7th.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

