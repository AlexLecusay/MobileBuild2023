//
//  ClassDetailsView.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 3/3/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ClassDetailsView: View {
    let classItem: Class
    
    var body: some View {
        VStack {
            Text(classItem.title)
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
        let classItem = Class(title: "Class Title", description: "Class Description", isHomePage: true)
        
        NavigationView {
            ClassDetailsView(classItem: classItem)
        }
    }
}
