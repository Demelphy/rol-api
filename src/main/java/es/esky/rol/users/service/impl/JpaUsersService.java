/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.esky.rol.users.service.impl;

import es.esky.rol.users.domain.User;
import es.esky.rol.users.repository.UsersRepository;
import es.esky.rol.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * JPA implementation of {@link UsersService}.
 *
 * @author Cristian Mateos López
 * @since 1.0.0
 */
@Service
public class JpaUsersService implements UsersService {

    private final UsersRepository usersRepository;

    /**
     * Constructor of JpaUsersService
     *
     * @param usersRepository UsersRepository dependency.
     */
    @Autowired
    public JpaUsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Page<User> findByCriteria(Pageable page) {
        return usersRepository.findAll(page);
    }
}
