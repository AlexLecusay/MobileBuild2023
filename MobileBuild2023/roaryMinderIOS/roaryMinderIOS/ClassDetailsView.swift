//
//  ClassDetailsView.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 3/3/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ClassDetailsView: View {
    let classItem: RoaryRepoInfo
    
    var body: some View {
        VStack {
            Text(classItem.className)
                .font(.title)
                .fontWeight(.bold)
                .padding(.bottom, 8)
            
            Text(classItem.description)
                .font(.body)
                .multilineTextAlignment(.center)
                .padding(.horizontal)
        }
    }
}

struct ClassDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        let classItem = RoaryRepoInfo()
        
        NavigationView {
            ClassDetailsView(classItem: classItem)
        }
    }
}
