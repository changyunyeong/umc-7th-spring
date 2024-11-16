package umc7th.example.umc7th.service.MemberService;

import umc7th.example.umc7th.domain.Member;
import umc7th.example.umc7th.web.dto.MemberRequestDTO;
import umc7th.example.umc7th.web.dto.MemberResponseDTO;

public interface MemberCommandService {

    Member joindMember(MemberRequestDTO.JoinDto request);
}
