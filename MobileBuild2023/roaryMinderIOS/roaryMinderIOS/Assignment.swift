//
//  Assignment.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 4/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared

extension shared.Assignment: Identifiable {
    public var id: UUID {
        return UUID()
    }
}

//
//struct Assignment: Identifiable {
//    var id = UUID()
//    var title: String
//    var description: String
//    var date: Date
//    var course: String
//    var chats: ChatRepo
//}
