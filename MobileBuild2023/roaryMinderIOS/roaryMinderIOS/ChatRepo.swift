//
//  ChatRepo.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 4/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import RealmSwift
import Foundation

func toArray<T>(_ list: NSMutableArray) -> [T] {
    return list.compactMap { $0 as? T }
}
