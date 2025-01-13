package com.blog.blogapp.account;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {

//    private final AccountRepository accountRepository;
//    private final AuthorityRepository authorityRepository;

    public Account save(Account account) {

//        if (account.getId() == null) {
//            if (account.getAuthorities().isEmpty()) {
//                Set<Authority> authorities = new HashSet<>();
//                authorityRepository.findById("ROLE_USER").ifPresent(authorities::add);
//                account.setAuthorities(authorities);
//            }
//            account.setCreatedAt(LocalDateTime.now());
//        }
//        account.setUpdatedAt(LocalDateTime.now());
//        account.setPassword(passwordEncoder.encode(account.getPassword()));
//        return accountRepository.save(account);
        return null;
    }

//    public Optional<Account> findOneByEmail(String email) {
//        return accountRepository.findOneByEmailIgnoreCase(email);
//    }
}
